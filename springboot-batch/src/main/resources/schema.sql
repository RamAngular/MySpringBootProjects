--Many database vendors dont support sequences. In these cases, work-arounds are used, such as the following for MySQL:

--CREATE TABLE BATCH_STEP_EXECUTION_SEQ (ID BIGINT NOT NULL) type=InnoDB;
--INSERT INTO BATCH_STEP_EXECUTION_SEQ values(0);
--CREATE TABLE BATCH_JOB_EXECUTION_SEQ (ID BIGINT NOT NULL) ENGINE=InnoDB;
--INSERT INTO BATCH_JOB_EXECUTION_SEQ values(0);
--CREATE TABLE BATCH_JOB_SEQ (ID BIGINT NOT NULL) type=InnoDB;
--INSERT INTO BATCH_JOB_SEQ values(0);

DROP TABLE  IF EXISTS people;

CREATE TABLE people(person_id int  NOT NULL PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(20),last_name VARCHAR(20));

--The simple way would be to disable the foreign key check; make the changes then re-enable foreign key check.

-- SET FOREIGN_KEY_CHECKS=0; -- to disable them
-- SET FOREIGN_KEY_CHECKS=1; -- to re-enable them