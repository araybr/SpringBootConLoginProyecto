package com.example.springbootloginclase2425.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class TimeStampedPersistableObject {

    @Column(nullable = false, name = "insert_ts", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTimeStamp;

    @Column(nullable = false, name = "update_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimeStamp;

    @PrePersist
    private void onInsert() {
        this.insertTimeStamp = new Date();
        this.updateTimeStamp = insertTimeStamp;
    }

    @PreUpdate
    private void onUpdate() {
        this.updateTimeStamp = new Date();
    }


}
