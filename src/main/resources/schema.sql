DROP TABLE IF EXISTS `Foods`;
CREATE TABLE `Foods` (
`id`   INTEGER  PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`description` VARCHAR(50),
food_type VARCHAR(50),
price NUMERIC
);

DROP TABLE IF EXISTS `FoodCategory`;
CREATE TABLE `FoodCategory` (
 `id`   INTEGER  PRIMARY KEY AUTO_INCREMENT,
 categoryName VARCHAR(50)
);
