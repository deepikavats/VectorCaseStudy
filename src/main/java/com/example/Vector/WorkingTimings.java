package com.example.Vector;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "workingtimings")
public class WorkingTimings {

    @Id
    @Column(name = "dayname")
    String day;

    @Column(name = "starttime")
    LocalTime startTime;

    @Column(name = "endtime")
    LocalTime endTime;


}
