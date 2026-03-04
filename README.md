# SPRING PLUS

Spring Boot 기반 Todo 관리 API 프로젝트입니다.
JPA, QueryDSL, Spring Security, AOP 등을 활용하여 인증, 데이터 처리, 성능 개선(N+1), 테스트 코드 개선 등의 개념을 학습하고 적용하는 것을 목표로 구현되었습니다.

---

## 기술 스택

- Java 17
- Spring Boot
- Spring Security, JWT
- Spring Data JPA
- JPQL, QueryDSL
- MySQL
- JUnit5, MockMvc
- Gradle

---

## 주요 기능
- JWT 기반 인증 시스템
- Todo 생성 및 관리 기능
- 관리자 권한 관리
- 댓글(Comment) 조회 기능
- Todo 검색 기능
- QueryDSL 기반 조회
- N+1 문제 해결
- AOP 기반 관리자 접근 로깅

---

## 구현 내용
1. Transaction 관리 개선
- Todo 저장 기능에서 발생하던 read-only 트랜잭션 오류를 수정하여 정상적으로 데이터가 저장되도록 개선했습니다.
  - 트랜잭션 설정 문제 해결
  - 데이터 변경 작업에 적절한 트랜잭션 적용

2. JWT 기능 확장
- 사용자 정보에 nickname 필드를 추가하고 JWT 토큰에 닉네임 정보를 포함하도록 개선했습니다.
  - User 테이블에 nickname 컬럼 추가
  - JWT Payload에 nickname 정보 포함
  - 프론트엔드에서 사용자 닉네임 활용 가능

3. Todo 검색 기능 개선 (JPQL)
- Todo 조회 시 다양한 조건으로 검색할 수 있도록 기능을 확장했습니다.
   검색 조건
   - 날씨(weather)
   - 수정일 기준 기간 검색

    각 조건은 선택적으로 적용될 수 있도록 구현했습니다.

4. Controller 테스트 코드 수정
- Todo 단건 조회 테스트에서 발생하던 실패 문제를 해결했습니다.
   - 존재하지 않는 Todo 조회 시 예외 처리 개선
   - Controller 테스트가 정상적으로 통과하도록 수정

5. AOP 적용
- 관리자 권한 변경 API 호출 시 접근 로그가 기록되도록 AOP를 수정했습니다.
   - 특정 관리자 API 실행 전 로그 기록
   - Pointcut 설정 개선

6. JPA Cascade 활용
- Todo 생성 시 생성한 사용자가 자동으로 담당자로 등록되도록 Cascade 기능을 적용했습니다.
   - Todo 저장 시 관련 엔티티 자동 저장
   - 담당자 등록 로직 간소화

7. N+1 문제 해결
- 댓글 조회 API에서 발생하던 N+1 문제를 해결하여 성능을 개선했습니다.
   - 연관 엔티티 조회 방식 개선
   - 불필요한 쿼리 발생 방지

8. QueryDSL 적용
- 기존 JPQL 기반 조회 로직을 QueryDSL로 변경했습니다.
   - 타입 안전성 확보
   - 동적 쿼리 작성 용이
   - N+1 문제 방지

9. Spring Security 도입
- 기존 인증 방식을 Spring Security 기반 구조로 변경했습니다.
   - JWT 기반 인증 유지
   - 권한(Role) 기반 접근 제어 적용
   - SecurityContext를 활용한 사용자 인증 관리

---

## 학습 내용
이번 프로젝트를 통해 다음 내용을 학습했습니다.
- Spring Transaction 동작 방식
- JWT 인증 구조
- JPA Cascade 사용 방법
- N+1 문제 발생 원인과 해결 방법
- QueryDSL 활용 방법
- Spring Security 인증 및 권한 처리
- AOP를 활용한 공통 로직 처리
- Controller 테스트 작성 및 개선
