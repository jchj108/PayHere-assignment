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

## SWAGGER 실행 관련
1. 서버 실행 후 http://localhost:8080/swagger-ui/index.html 로 접속하면 스웨거를 통해 API 테스트가 가능합니다.
2. UserController는 security의 인증 path에서 제외했습니다.

<img width="1372" alt="image" src="https://user-images.githubusercontent.com/75921378/186226224-32d99132-3c5e-40fb-a6d6-7803427a82da.png">

3. 로그인 시 access_token 토큰이 응답값으로 돌아옵니다.

4. Authorize 버튼을 클릭 후 Bearer {토큰} 을 입력하면 Ledger 컨트롤러와 관련해서 인증을 인가받게 됩니다.

<img width="1058" alt="image" src="https://user-images.githubusercontent.com/75921378/186226651-504ec122-c8a4-43ef-8251-894b50d4a2d3.png">

## 구현 API

![image](https://user-images.githubusercontent.com/75921378/186226830-db96cd35-f1b3-4df1-863b-db5591ac08db.png)


## API CALL Example



