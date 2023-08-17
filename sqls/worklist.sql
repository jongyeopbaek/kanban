CREATE TABLE `kanban`.`worklist` (
                            `workNo` INT NOT NULL AUTO_INCREMENT,
                            `userNo` INT NULL,
                            `status` ENUM('READY', 'PROGRESS', 'DONE', 'POSTPONE') NOT NULL DEFAULT 'READY',
                            `subject` VARCHAR(255) NOT NULL,
                            `content` LONGTEXT NOT NULL,
                            `regDt` DATETIME NULL DEFAULT NOW(),
                            `modDt` DATETIME NULL,
                            PRIMARY KEY (`workNo`));