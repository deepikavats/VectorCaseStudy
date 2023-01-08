package com.example.Vector;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LicenseDataRepository extends CrudRepository<LicenseData, String> {

    LicenseData findByCompilerNameAndLicenseDate(String name, LocalDate date);
}
