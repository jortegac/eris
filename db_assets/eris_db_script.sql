SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `eris` DEFAULT CHARACTER SET utf8 ;
USE `eris` ;

-- -----------------------------------------------------
-- Table `eris`.`appliance_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eris`.`appliance_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `average_consumption` DOUBLE NOT NULL,
  `average_usage` DOUBLE NOT NULL,
  `version` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eris`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eris`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `gender` VARCHAR(1) NULL DEFAULT NULL,
  `dateCreated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `version` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eris`.`appliance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eris`.`appliance` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `appliance_type_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `date_of_purchase` DATETIME NULL DEFAULT NULL,
  `expected_consumption` DOUBLE NOT NULL,
  `version` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_appliance_user_idx` (`user_id` ASC),
  INDEX `fk_appliance_appliance_type1_idx` (`appliance_type_id` ASC),
  CONSTRAINT `fk_appliance_appliance_type1`
    FOREIGN KEY (`appliance_type_id`)
    REFERENCES `eris`.`appliance_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appliance_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `eris`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `eris`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eris`.`event` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `appliance_id` INT(11) NOT NULL,
  `running_time` DOUBLE NOT NULL,
  `energy_consumption` DOUBLE NOT NULL,
  `time` DATETIME NOT NULL,
  `version` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_user1_idx` (`user_id` ASC),
  INDEX `fk_event_appliance1_idx` (`appliance_id` ASC),
  CONSTRAINT `fk_event_appliance1`
    FOREIGN KEY (`appliance_id`)
    REFERENCES `eris`.`appliance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `eris`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 102;


-- -----------------------------------------------------
-- Table `eris`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eris`.`state` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `activity_level` DOUBLE NOT NULL,
  `energy_cost` DOUBLE NOT NULL,
  `satisfaction` DOUBLE NOT NULL,
  `attitude` DOUBLE NOT NULL,
  `intention` DOUBLE NOT NULL,
  `engagement` DOUBLE NOT NULL,
  `dateCreated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_state_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_state_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `eris`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eris`.`advice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eris`.`advice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `appliance_type_id` INT NOT NULL,
  `type` INT NOT NULL,
  `message` VARCHAR(500) NOT NULL,
  `is_taken` TINYINT(1) NOT NULL,
  `dateCreated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_advice_user1_idx` (`user_id` ASC),
  INDEX `fk_advice_appliance_type_idx` (`appliance_type_id` ASC),
  CONSTRAINT `fk_advice_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `eris`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_advice_appliance_type`
    FOREIGN KEY (`appliance_type_id`)
    REFERENCES `eris`.`appliance_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
