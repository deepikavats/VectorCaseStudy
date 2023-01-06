create table IF NOT EXISTS license(
    compilername char(6) not null PRIMARY KEY,
    numberoflicenseinworkinghours int not null,
    numberoflicenseinnonworkinghours int not null,
    currentlicense int
);