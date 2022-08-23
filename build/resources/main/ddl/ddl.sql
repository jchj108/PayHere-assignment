CREATE TABLE  `User` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `Ledger` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` bigint DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `writedTime` datetime(6) DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `LEDGERFK` (`userId`),
  CONSTRAINT `LEDGERFKCONSTRAINT` FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
