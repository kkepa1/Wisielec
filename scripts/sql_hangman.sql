create database sql_hangman;
use sql_hangman;

CREATE TABLE `passwords` (
                         `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         `password` VARCHAR(250) NOT NULL UNIQUE
);

insert into `passwords` (`password`)
values ('DZIS JEST PIATEK'),
       ('JUTRO JEST SOBOTA'),
       ('ZOO W POZNANIU'),
       ('GDANSK'),
       ('PRACA W DELOITTE'),
       ('NEW PASSWORD'),
       ('DELOITTE');
