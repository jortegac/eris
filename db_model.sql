SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `age` INT NULL,
  `gender` VARCHAR(1) NULL,
  `dateCreated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`appliance_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`appliance_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `average_consumption` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`appliance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`appliance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `appliance_type_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `date_of_purchase` DATETIME NULL,
  `expected_consumption` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_appliance_user_idx` (`user_id` ASC),
  INDEX `fk_appliance_appliance_type1_idx` (`appliance_type_id` ASC),
  CONSTRAINT `fk_appliance_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appliance_appliance_type1`
    FOREIGN KEY (`appliance_type_id`)
    REFERENCES `mydb`.`appliance_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `appliance_id` INT NOT NULL,
  `activity_level` INT NOT NULL,
  `energy_consumption` DOUBLE NOT NULL,
  `time` DATETIME NOT NULL,
  INDEX `fk_event_user1_idx` (`user_id` ASC),
  INDEX `fk_event_appliance1_idx` (`appliance_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_appliance1`
    FOREIGN KEY (`appliance_id`)
    REFERENCES `mydb`.`appliance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`state` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  `activity_level` DOUBLE NOT NULL,
  `energy_cost` DOUBLE NOT NULL,
  `satisfaction` DOUBLE NOT NULL,
  `attitude` DOUBLE NOT NULL,
  `intention` DOUBLE NOT NULL,
  `engagement` DOUBLE NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`, `event_id`),
  INDEX `fk_state_user1_idx` (`user_id` ASC),
  INDEX `fk_state_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_state_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_state_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `mydb`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
