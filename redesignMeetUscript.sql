-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema meetu
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `meetu` ;

-- -----------------------------------------------------
-- Schema meetu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `meetu` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `meetu` ;

-- -----------------------------------------------------
-- Table `meetu`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`user` (
  `idUser` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `image` BLOB NULL DEFAULT NULL,
  `password` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`calendar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`calendar` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`calendar` (
  `idCalendar` INT(11) NOT NULL,
  `user_idUser` INT(11) NOT NULL,
  `day_number` SMALLINT(2) NOT NULL,
  `day_date` DATETIME NOT NULL,
  `time_in_hours` DATETIME NOT NULL,
  `other_details` TINYTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idCalendar`),
  CONSTRAINT `fk_Calendar_User1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Calendar_User1_idx` ON `meetu`.`calendar` (`user_idUser` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`plan` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`plan` (
  `idPlan` INT(11) NOT NULL,
  `user_idUser` INT(11) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idPlan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`comment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`comment` (
  `commentary` TEXT NOT NULL,
  `date` DATETIME NOT NULL,
  `Plan_idEvent` INT(11) NOT NULL,
  `User_idUser` INT(11) NOT NULL,
  PRIMARY KEY (`User_idUser`),
  CONSTRAINT `fk_Comments_Plan1`
    FOREIGN KEY (`Plan_idEvent`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comments_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Comments_Plan1_idx` ON `meetu`.`comment` (`Plan_idEvent` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`tag` (
  `idTags` INT(11) NOT NULL,
  `event_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTags`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`event_has_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`event_has_tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`event_has_tag` (
  `tag_idTag` INT(11) NOT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  PRIMARY KEY (`tag_idTag`, `plan_idPlan`),
  CONSTRAINT `fk_Tags_has_Event_Event1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tags_has_Event_Tags1`
    FOREIGN KEY (`tag_idTag`)
    REFERENCES `meetu`.`tag` (`idTags`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Tags_has_Event_Event1_idx` ON `meetu`.`event_has_tag` (`plan_idPlan` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_Tags_has_Event_Tags1_idx` ON `meetu`.`event_has_tag` (`tag_idTag` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`friendship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`friendship` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`friendship` (
  `user_idUser1` INT(11) NULL,
  `user_idUser2` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  CONSTRAINT `fk_Friendship_Users1`
    FOREIGN KEY (`user_idUser1`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Friendship_Users2`
    FOREIGN KEY (`user_idUser2`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Users_idUser1_UNIQUE` ON `meetu`.`friendship` (`user_idUser1` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `Users_idUser2_UNIQUE` ON `meetu`.`friendship` (`user_idUser2` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_Friendship_Users1_idx` ON `meetu`.`friendship` (`user_idUser1` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_Friendship_Users2_idx` ON `meetu`.`friendship` (`user_idUser2` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`preference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`preference` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`preference` (
  `idPreference` INT(11) NOT NULL,
  `event_type_name` VARCHAR(45) NOT NULL,
  `user_idUser` INT(11) NOT NULL,
  PRIMARY KEY (`idPreference`, `user_idUser`),
  CONSTRAINT `fk_Preferences_User1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Preferences_User1_idx` ON `meetu`.`preference` (`user_idUser` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`preference_has_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`preference_has_tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`preference_has_tag` (
  `preference_idPreferences` INT(11) NOT NULL,
  `preference_user_idUser` INT(11) NOT NULL,
  `tag_idTag` INT(11) NOT NULL,
  PRIMARY KEY (`preference_idPreferences`, `preference_user_idUser`, `tag_idTag`),
  CONSTRAINT `fk_Preferences_has_Tags_Preferences1`
    FOREIGN KEY (`preference_idPreferences` , `preference_user_idUser`)
    REFERENCES `meetu`.`preference` (`idPreference` , `user_idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Preferences_has_Tags_Tags1`
    FOREIGN KEY (`tag_idTag`)
    REFERENCES `meetu`.`tag` (`idTags`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Preferences_has_Tags_Tags1_idx` ON `meetu`.`preference_has_tag` (`tag_idTag` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_Preferences_has_Tags_Preferences1_idx` ON `meetu`.`preference_has_tag` (`preference_idPreferences` ASC, `preference_user_idUser` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`reminder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`reminder` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`reminder` (
  `idReminder` INT(11) NOT NULL,
  `schedule_time` DATETIME NOT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  `plan_user_idUser` INT(11) NOT NULL,
  PRIMARY KEY (`idReminder`),
  CONSTRAINT `fk_Reminder_Plan1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Reminder_Plan1_idx` ON `meetu`.`reminder` (`plan_idPlan` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`role` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`role` (
  `idrole` INT(11) NOT NULL,
  `role_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idrole`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`role_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`role_has_user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`role_has_user` (
  `role_idRole` INT(11) NOT NULL,
  `user_idUser` INT(11) NOT NULL,
  PRIMARY KEY (`role_idRole`, `user_idUser`),
  CONSTRAINT `fk_roles_has_users_roles1`
    FOREIGN KEY (`role_idRole`)
    REFERENCES `meetu`.`role` (`idrole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_users_users1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_roles_has_users_users1_idx` ON `meetu`.`role_has_user` (`user_idUser` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_roles_has_users_roles1_idx` ON `meetu`.`role_has_user` (`role_idRole` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`role_has_user_has_plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`role_has_user_has_plan` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`role_has_user_has_plan` (
  `role_has_user_role_idRole` INT(11) NOT NULL,
  `role_has_user_user_idUser` INT(11) NOT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  PRIMARY KEY (`role_has_user_role_idRole`, `role_has_user_user_idUser`, `plan_idPlan`),
  CONSTRAINT `fk_roles_has_users_has_plans_plans1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_users_has_plans_roles_has_users1`
    FOREIGN KEY (`role_has_user_role_idRole` , `role_has_user_user_idUser`)
    REFERENCES `meetu`.`role_has_user` (`role_idRole` , `user_idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_roles_has_users_has_plans_plans1_idx` ON `meetu`.`role_has_user_has_plan` (`plan_idPlan` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_roles_has_users_has_plans_roles_has_users1_idx` ON `meetu`.`role_has_user_has_plan` (`role_has_user_role_idRole` ASC, `role_has_user_user_idUser` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`suggested_budget`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`suggested_budget` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`suggested_budget` (
  `idBudget` INT(11) NOT NULL,
  `money` INT(11) NOT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  PRIMARY KEY (`idBudget`),
  CONSTRAINT `fk_Budget_Plan1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Budget_Plan1_idx` ON `meetu`.`suggested_budget` (`plan_idPlan` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`suggested_date`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`suggested_date` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`suggested_date` (
  `idDate` INT(11) NOT NULL,
  `start_date` VARCHAR(45) NULL DEFAULT NULL,
  `end_date` VARCHAR(45) NULL DEFAULT NULL,
  `time` VARCHAR(45) NULL DEFAULT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  PRIMARY KEY (`idDate`),
  CONSTRAINT `fk_Suggested_Dates_Plan1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Suggested_Dates_Plan1_idx` ON `meetu`.`suggested_date` (`plan_idPlan` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`suggested_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`suggested_location` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`suggested_location` (
  `idLocation` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `coordinate` POINT NOT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  PRIMARY KEY (`idLocation`),
  CONSTRAINT `fk_Location_Plan1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Location_Plan1_idx` ON `meetu`.`suggested_location` (`plan_idPlan` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `meetu`.`user_has_plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `meetu`.`user_has_plan` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `meetu`.`user_has_plan` (
  `user_idUser` INT(11) NOT NULL,
  `plan_idPlan` INT(11) NOT NULL,
  PRIMARY KEY (`user_idUser`, `plan_idPlan`),
  CONSTRAINT `fk_User_has_Plan_Plan1`
    FOREIGN KEY (`plan_idPlan`)
    REFERENCES `meetu`.`plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Plan_User1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `meetu`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_User_has_Plan_Plan1_idx` ON `meetu`.`user_has_plan` (`plan_idPlan` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_User_has_Plan_User1_idx` ON `meetu`.`user_has_plan` (`user_idUser` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
