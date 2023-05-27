package com.example.fire_department.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "special_vehicle_revision")
public class SpecialVehicleRevision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer revisionId;
    @Column(name = "licence_plate_number", length = 15)
    private String licencePlateNumber;
    @Column(name = "revision_date")
    private Date revisionDate;
    @Column(name = "revision_description", length = 150)
    private String revisionDescription;
    @Column(name = "service", length = 20)
    private String service;

    public SpecialVehicleRevision() {

    }

    public SpecialVehicleRevision(String licencePlateNumber, Date revisionDate, String revisionDescription, String service) {
        this.licencePlateNumber = licencePlateNumber;
        this.revisionDate = revisionDate;
        this.revisionDescription = revisionDescription;
        this.service = service;
    }

    public Integer getRevisionId() {
        return revisionId;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getRevisionDescription() {
        return revisionDescription;
    }

    public void setRevisionDescription(String revisionDescription) {
        this.revisionDescription = revisionDescription;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
