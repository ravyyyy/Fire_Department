CREATE TABLE IF NOT EXISTS fire_station (
	unit_id VARCHAR(15) PRIMARY KEY,
    address VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    county VARCHAR(30) NOT NULL,
    employees_count INTEGER,
    special_vehicles_count INTEGER,
    interventions_count INTEGER
);

CREATE TABLE IF NOT EXISTS employee_equipment (
    employee_equipment_id SERIAL PRIMARY KEY,
    employee_id INTEGER,
    equipment_condition VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS employee_type (
  employee_type_id SERIAL PRIMARY KEY,
  employee_type_name VARCHAR(45),
  retirement_age INTEGER
);

CREATE TABLE IF NOT EXISTS employee (
	employee_id SERIAL PRIMARY KEY,
	unit_id VARCHAR(15),
	badge_id VARCHAR(30) NOT NULL UNIQUE,
	employee_equipment_id INT,
	interventions_count INT,
	length_of_service VARCHAR(20),
	salary INT,
	title VARCHAR(20),
	employee_state VARCHAR(25),
	employee_type_id INT,
	employee_name VARCHAR(20),
	employee_surname VARCHAR(20),
	
	FOREIGN KEY (unit_id) REFERENCES fire_station(unit_id),
	FOREIGN KEY (employee_equipment_id) REFERENCES employee_equipment(employee_equipment_id),
	FOREIGN KEY (employee_type_id) REFERENCES employee_type(employee_type_id)
);

ALTER TABLE employee_equipment 
ADD CONSTRAINT fk_employee 
FOREIGN KEY (employee_id) 
REFERENCES employee(employee_id);

CREATE TABLE IF NOT EXISTS duty_shift (
	shift_id SERIAL PRIMARY KEY,
	employee_id INT,
	shift_date DATE,
	
	FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS special_vehicle_type (
	category_name VARCHAR(100) PRIMARY KEY,
	special_vehicle_batch VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS vehicle_equipment (
	equipment_id SERIAL PRIMARY KEY,
	licence_plate_number VARCHAR(15) UNIQUE,
	equipment_condition VARCHAR(25),
	equipment_name VARCHAR(35)
);

CREATE TABLE IF NOT EXISTS special_vehicle (
	licence_plate_number VARCHAR(15) PRIMARY KEY,
	unit_id VARCHAR(15),
	special_vehicle_type VARCHAR(100),
	vehicle_driver_id INT,
	vehicle_condition VARCHAR(25),
	mileage VARCHAR(10),
	fabrication_year INT,
	interventions_count INT,
	vehicle_equipment_id INT,
	
	FOREIGN KEY (unit_id) REFERENCES fire_station(unit_id),
	FOREIGN KEY (special_vehicle_type) REFERENCES special_vehicle_type(category_name),
	FOREIGN KEY (vehicle_driver_id) REFERENCES employee(employee_id),
	FOREIGN KEY (vehicle_equipment_id) REFERENCES vehicle_equipment(equipment_id)
);

ALTER TABLE vehicle_equipment
ADD CONSTRAINT fk_vehicle_equipment
FOREIGN KEY (licence_plate_number)
REFERENCES special_vehicle(licence_plate_number);

CREATE TABLE IF NOT EXISTS special_vehicle_revision (
	revision_id SERIAL PRIMARY KEY,
	licence_plate_number VARCHAR(15),
	revision_date DATE,
	revision_description VARCHAR(150),
	service VARCHAR(20),
	
	FOREIGN KEY (licence_plate_number) REFERENCES special_vehicle(licence_plate_number)
);

CREATE TABLE IF NOT EXISTS special_vehicle_crew (
	licence_plate_number VARCHAR(15),
	employee_id INT,
	
	FOREIGN KEY (licence_plate_number) REFERENCES special_vehicle(licence_plate_number),
	FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS intervention (
	intervention_id SERIAL PRIMARY KEY,
	intervention_date DATE,
	intervention_type VARCHAR(50),
	intervention_leader_id INT,
	intervention_duration VARCHAR(15),
	
	FOREIGN KEY (intervention_leader_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS special_vehicle_intervention (
	intervention_id SERIAL PRIMARY KEY,
	licence_plate_number VARCHAR(15),
	
	FOREIGN KEY (licence_plate_number) REFERENCES special_vehicle(licence_plate_number)
);

CREATE TABLE IF NOT EXISTS intervention_crew (
	intervention_id INT,
	employee_id INT,
	
	FOREIGN KEY (intervention_id) REFERENCES intervention(intervention_id),
	FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);