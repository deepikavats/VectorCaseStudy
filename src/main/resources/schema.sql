create table IF NOT EXISTS license(
    compilername char(16) not null PRIMARY KEY,
    numberoflicenseinworkinghours int not null,
    numberoflicenseinnonworkinghours int not null,
    currentlicense int
);

create table IF NOT EXISTS licensedata(
    compilername char(16) not null PRIMARY KEY,
    licensedate DATE not null,
    licensesusedbyci int
);

create table IF NOT EXISTS workingtimings(
    dayname char(16) not null PRIMARY KEY,
    starttime TIME not null,
    endtime TIME not null
);

