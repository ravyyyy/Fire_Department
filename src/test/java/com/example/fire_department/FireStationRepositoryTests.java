package com.example.fire_department;

import com.example.fire_department.models.FireStation;
import com.example.fire_department.repositories.FireStationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FireStationRepositoryTests {
    @Autowired
    private FireStationRepository fireStationRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindByCounty() {
        FireStation fireStation1 = new FireStation();
        fireStation1.setUnitId("BZ-15523");
        fireStation1.setAddress("");
        fireStation1.setCity("");
        fireStation1.setCounty("Buzau");
        entityManager.persist(fireStation1);

        FireStation fireStation2 = new FireStation();
        fireStation2.setUnitId("BV-68233");
        fireStation2.setAddress("");
        fireStation2.setCity("");
        fireStation2.setCounty("Brasov");
        entityManager.persist(fireStation2);

        entityManager.flush();

        List<FireStation> fireStations = fireStationRepository.findByCounty("Buzau");

        assertEquals("Buzau", fireStations.get(fireStations.size() - 1).getCounty());
    }
}
