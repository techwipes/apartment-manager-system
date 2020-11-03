-- -----------------------------------------------------
-- Schema apartment_manager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apartment_manager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `apartment_manager` ;


-- -----------------------------------------------------
-- Table `apartment_manager`.`account`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS account (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account_number INT NOT NULL,
  owner_last_name VARCHAR(60),
  owner_name VARCHAR(60),
  apartment_number INT NOT NULL,
  balance DOUBLE
  ) engine=InnoDB;