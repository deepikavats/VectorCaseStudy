create table IF NOT EXISTS LICENSE(
    compilerName char(6) not null PRIMARY KEY,
    numberOfLicenseInWorkingHours int not null,
    numberOfLicenseInNonWorkingHours int not null,
    currentLicense int
);