# PayHere-assignment


## Requirement

1. Docker

## 실행법

1. git clone this repository
2. 터미널에서 docker-compose up 명령어 실행

## 실행환경

1. Mysql 5.7
2. Gradle
3. JAVA 17
4. Spring boot

## DDL

```
  CREATE TABLE  `User` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

```
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
```

## SWAGGER 실행 관련

1. 서버 실행 후 http://localhost:8080/swagger-ui/index.html 로 접속하면 스웨거를 통해 API 테스트가 가능합니다.
2. UserController는 security의 인증 path에서 제외했습니다.

<img width="1372" alt="image" src="https://user-images.githubusercontent.com/75921378/186226224-32d99132-3c5e-40fb-a6d6-7803427a82da.png">

3. 로그인 시 access_token 토큰이 응답값으로 돌아옵니다.

4. Authorize 버튼을 클릭 후 Bearer {토큰} 을 입력하면 Ledger 컨트롤러와 관련해서 인증을 인가받게 됩니다.

<img width="1058" alt="image" src="https://user-images.githubusercontent.com/75921378/186226651-504ec122-c8a4-43ef-8251-894b50d4a2d3.png">

## 구현 API

![image](https://user-images.githubusercontent.com/75921378/186226830-db96cd35-f1b3-4df1-863b-db5591ac08db.png)


## Security + JWT FLOW

1. 각 API Endpoint에 요청이 들어왔을 때, DispatcherServlet으로 도달하기 전에 JwtTokenFilter가 유효한 토큰인지 검사
2. 토큰이 존재하지만 만료되었거나 유효하지 않다면 예외 처리 수행
3. 로그인 시 DB에 저장된 실제 유저 데이터와 유저가 입력한 아이디와 비밀번호를 비교. 이때 유저가 입력 비밀번호는 암호화 과정을 거친다. 일치하지 않는다면 로그인 실패 예외 리턴
5. 시큐리티 antMatcher에서 Permit되지 않은 모든 URI Path에 대해 인증 절차 수행
6. 유효한 토큰이라면 API 접근 인가, 유효하지 않거나 토큰이 존재하지 않는다면 UnAuthorized 예외 리턴

