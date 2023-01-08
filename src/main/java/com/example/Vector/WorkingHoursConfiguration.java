package com.example.Vector;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "workinghoursconfiguration")
public class WorkingHoursConfiguration {

    @Id
    @Column(name = "dayname")
    String day;

    @Column(name = "starthours")
    int startHours;

    @Column(name = "startminutes")
    int startminutes;

    @Column(name = "endhours")
    int endHours;

    @Column(name = "endminutes")
    int endMinutes;

}
