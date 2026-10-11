

CREATE TABLE Schools
(
    SchoolID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name VARCHAR(150) NOT NULL,
    IsPostPrimary BIT NOT NULL
);


CREATE TABLE Students
(
    StudentID INTEGER PRIMARY KEY AUTOINCREMENT,
    fullName VARCHAR(100) NOT NULL,
    SchoolID INTEGER NOT NULL REFERENCES Schools(SchoolID),
    Bio VARCHAR(750),
    ImagePath VARCHAR(255),
    Email VARCHAR(100),
    Phone VARCHAR(20),
    BecameUniversityStudent BIT NOT NULL, 
    UniversitySchoolID INTEGER REFERENCES Students(StudentID),
    UniversityGraduateYear INTEGER,
    [Major/Interest] VARCHAR(100)
);

CREATE TABLE Users
(
    UserID INTEGER PRIMARY KEY AUTOINCREMENT,
    Username VARCHAR(50) UNIQUE,
    PasswordValue VARCHAR(255),
    StudentID INTEGER REFERENCES Students(StudentID),
    IsAdministrator BIT NOT NULL
); 


--End of minium viable tables.

CREATE TABLE SchoolTerm
(
    StudentID INTEGER REFERENCES Students(StudentID),
    Year INTEGER NOT NULL,
    Term INTEGER NOT NULL,
    SchoolID INTEGER NOT NULL REFERENCES Schools(SchoolID),
    TuitionFees DECIMAL(10, 2) NOT NULL,
    SchoolGrade DECIMAL(3, 1) NOT NULL,
    
    PRIMARY KEY (StudentID, Year, Term) 
);

CREATE TABLE ExtraFees
(
    FeeID INTEGER PRIMARY KEY AUTOINCREMENT,
    StudentID INTEGER,
    Year INTEGER,
    Term BIT,
    FeeType VARCHAR(100) NOT NULL,
    FeeAmount DECIMAL(10, 2) NOT NULL,
    
    FOREIGN KEY (StudentID, Year, Term) REFERENCES SchoolTerm(StudentID, Year, Term)
);

CREATE TABLE UniversityYear
(
    StudentID INTEGER REFERENCES UniversityStudents(StudentID),
    Year INTEGER NOT NULL,
    UniversityID INTEGER NOT NULL REFERENCES Universities(UniversityID),
    
    PRIMARY KEY (StudentID, Year) 
);
