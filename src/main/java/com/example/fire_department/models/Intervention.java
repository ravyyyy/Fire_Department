package com.example.fire_department.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "intervention")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer interventionId;
    @Column(name = "intervention_date")
    private Date interventionDate;
    @Column(name = "intervention_type", length = 50)
    private String interventionType;
    @Column(name = "intervention_leader_id")
    private Integer interventionLeaderId;
    @Column(name = "intervention_duration", length = 15)
    private String interventionDuration;

    public Intervention() {

    }

    public Intervention(Date interventionDate, String interventionType, Integer interventionLeaderId, String interventionDuration) {
        this.interventionDate = interventionDate;
        this.interventionType = interventionType;
        this.interventionLeaderId = interventionLeaderId;
        this.interventionDuration = interventionDuration;
    }

    public Integer getInterventionId() {
        return interventionId;
    }

    public Date getInterventionDate() {
        return interventionDate;
    }

    public void setInterventionDate(Date interventionDate) {
        this.interventionDate = interventionDate;
    }

    public String getInterventionType() {
        return interventionType;
    }

    public void setInterventionType(String interventionType) {
        this.interventionType = interventionType;
    }

    public Integer getInterventionLeaderId() {
        return interventionLeaderId;
    }

    public void setInterventionLeaderId(Integer interventionLeaderId) {
        this.interventionLeaderId = interventionLeaderId;
    }

    public String getInterventionDuration() {
        return interventionDuration;
    }

    public void setInterventionDuration(String interventionDuration) {
        this.interventionDuration = interventionDuration;
    }
}
