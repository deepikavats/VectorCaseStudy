package com.example.Vector;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Licensedata")
public class LicenseData {

    @Id
    @Column(name = "compilername")
    public String compilerName;

    @Column(name = "licensedate")
    public LocalDate licenseDate;

    @Column(name = "licensesusedbyci")
    public int licensesUsedByCi;
}
