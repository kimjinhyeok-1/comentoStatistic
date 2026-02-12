📘 SW 활용 현황 통계 API 명세서

프로젝트: comentoStatistic
기술스택: Spring Boot + MyBatis + MariaDB
Base URL: http://localhost:8031

1️⃣ 연도별 로그인 수 조회
🔹 URL
GET /api/v1/logins/{year}

🔹 설명

특정 연도의 전체 로그인(요청) 건수를 조회한다.

🔹 Path Variable
이름	타입	설명	예시
year	String	연도(앞 2자리)	20
🔹 요청 예시
GET /api/v1/logins/20

🔹 응답 예시 (200 OK)
{
  "year": "2020",
  "totCnt": 12345
}

🔹 내부 처리

request_info 테이블에서 create_date의 연도 기준 집계

SQL: LEFT(create_date,2)=#{year} 조건으로 COUNT

2️⃣ 연월별 로그인 수 조회
🔹 URL
GET /api/v1/logins/{year}/{month}

🔹 설명

특정 연월의 로그인 건수를 조회한다.

🔹 Path Variable
이름	타입	설명	예시
year	String	연도(앞 2자리)	20
month	String	월(2자리)	04
🔹 요청 예시
GET /api/v1/logins/20/04

🔹 응답 예시
{
  "yearMonth": "202004",
  "totCnt": 345
}

🔹 내부 처리

LEFT(create_date,4)=#{yearMonth} 조건으로 COUNT

3️⃣ 월별 접속자 수 (유니크)
🔹 URL
GET /api/v1/logins/monthly

🔹 설명

월별 유니크 접속자 수를 조회한다.
(중복 user_id 제거)

🔹 요청 예시
GET /api/v1/logins/monthly

🔹 응답 예시
[
  {
    "yearMonth": "202001",
    "totCnt": 50
  },
  {
    "yearMonth": "202002",
    "totCnt": 61
  }
]

🔹 내부 처리

COUNT(DISTINCT user_id)

월 단위 GROUP BY

4️⃣ 일별 접속자 수 (유니크)
🔹 URL
GET /api/v1/logins/daily

🔹 설명

일별 유니크 접속자 수를 조회한다.

🔹 응답 예시
[
  {
    "yyyymmdd": "20200401",
    "totCnt": 15
  },
  {
    "yyyymmdd": "20200402",
    "totCnt": 18
  }
]

🔹 내부 처리

COUNT(DISTINCT user_id)

일 단위 GROUP BY

5️⃣ 평균 하루 로그인 수
🔹 URL
GET /api/v1/logins/daily/avg

🔹 설명

일자별 로그인 수의 평균값을 조회한다.

🔹 응답 예시
{
  "avgDailyLogins": 12.4
}

🔹 내부 처리

서브쿼리로 일별 COUNT

AVG 집계

6️⃣ 부서별 월 로그인 수
🔹 URL
GET /api/v1/logins/dept/monthly

🔹 설명

부서별 월 로그인 건수를 조회한다.

🔹 응답 예시
[
  {
    "dept": "영업팀",
    "yearMonth": "202004",
    "totCnt": 120
  }
]

🔹 내부 처리

request_info + user 테이블 JOIN

부서 + 월 기준 GROUP BY

7️⃣ 일별 유니크 접속자 수 (휴일 제외)
🔹 URL
GET /api/v1/logins/daily/unique/exclude-holiday

🔹 설명

공휴일을 제외한 일별 유니크 접속자 수를 조회한다.

🔹 처리 방식 (과제 요구사항 반영)

SQL에서 (날짜, user) DISTINCT 조회

Service(Java)에서

holiday 테이블 조회

holidaySet 생성

휴일 날짜 제외

날짜별 유니크 집계

🔹 응답 예시
[
  {
    "yyyymmdd": "20200401",
    "totCnt": 13
  }
]

8️⃣ 월별 유니크 접속자 수 (휴일 제외)
🔹 URL
GET /api/v1/logins/monthly/unique/exclude-holiday

🔹 설명

공휴일을 제외한 월별 유니크 접속자 수를 조회한다.

🔹 처리 방식

SQL: (날짜, user) DISTINCT 조회

Java:

holiday 제외

month → Set<userId> 구성

Set size 집계

🔹 응답 예시
[
  {
    "yearMonth": "202004",
    "totCnt": 40
  }
]

🔎 공통 응답 규칙

Content-Type: application/json

HTTP Status: 200 OK
