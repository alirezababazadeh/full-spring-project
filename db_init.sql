CREATE TABLE STUDENT (
    ID BIGSERIAL PRIMARY KEY NOT NULL,
    FIRST_NAME VARCHAR(250) NOT NULL,
    LAST_NAME VARCHAR(250) NOT NULL,
    FIELD VARCHAR(250) NOT NULL,
    LEVEL VARCHAR(250) NOT NULL,
    AVERAGE DECIMAL(4,2) NOT NULL
);
INSERT INTO STUDENT (FIRST_NAME, LAST_NAME, FIELD, LEVEL, AVERAGE) VALUES
    ('Ali', 'Razavi', 'Computer', 'BS', 16.8),
    ('Farzin', 'Rahmati', 'Physics', 'BS', 17.6),
    ('Sina', 'Sajjadi', 'Electronic', 'MS', 19.4),
    ('Mahdi', 'Babaee', 'MBA', 'MS', 15.7),
    ('Ehsan', 'Jalali', 'Chemistry', 'BS', 18.5);

CREATE TABLE USER_ (
    ID BIGSERIAL PRIMARY KEY NOT NULL,
    USERNAME VARCHAR(255) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL UNIQUE,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL
);
INSERT INTO USER_ (USERNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME) VALUES
    ('Ali_R', '$2y$12$DZU.8pyXYhaK6vR/yrP2r.VOIUO.sFEEa3cmoJPmVWZqNlYPN9hv. ', 'alir@home.edu', 'Ali', 'Razavi'),
    ('Farzin_R', '$2y$12$DZU.8pyXYhaK6vR/yrP2r.VOIUO.sFEEa3cmoJPmVWZqNlYPN9hv. ', 'farzinr@home.edu', 'Farzin', 'Rahmati'),
    ('Sina_S', '$2y$12$DZU.8pyXYhaK6vR/yrP2r.VOIUO.sFEEa3cmoJPmVWZqNlYPN9hv. ', 'sinas@home.edu', 'Sina', 'Sajjadi'),
    ('Mahdi_B', '$2y$12$DZU.8pyXYhaK6vR/yrP2r.VOIUO.sFEEa3cmoJPmVWZqNlYPN9hv. ', 'mahdib@home.edu', 'Mahdi', 'Babaee'),
    ('Ehsan_E', '$2y$12$DZU.8pyXYhaK6vR/yrP2r.VOIUO.sFEEa3cmoJPmVWZqNlYPN9hv. ', 'ehsanj@home.edu', 'Ehsan', 'Jalali');

CREATE TABLE COURSE (
    ID BIGSERIAL PRIMARY KEY NOT NULL,
    TITLE VARCHAR(255) NOT NULL,
    UNIT BIGINT NOT NULL,
    DESCRIPTION VARCHAR(255) DEFAULT NULL
);
INSERT INTO COURSE (TITLE, UNIT) VALUES
    ('Math', 4),
    ('CLA', 3),
    ('DSD',  3),
    ('Conference', 2),
    ('DSDLab', 1);

