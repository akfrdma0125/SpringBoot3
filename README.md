# 스프링 부트 3 백엔드 개발자 되기 자바편

## JPA
### 초기 데이터셋 세팅
#### 관념적으로 다음과 같은 파일에 작성  
데이터 정의어(DDL): schema.sql  
데이터 조작어(DML): data.sql  

순서가 schema.sql / data.sql / ddl-auto 로 진행  
sql 문에 대한 로그가 별도로 남지는 않음


## 테스트
### JUnit
#### 자바 언어를 위한 단위 테스트 프레임워크(메서드 단위)
@SpringBootTest: @SpringBootApplication이 있는 클래스를 찾고, 그 클래스에 포함되어 있는 빈을 찾은 다음 테스트용 애플리케이션 컨텍스트 생성  
@AutoConfigureMockMvc: MockMvc 생성하고 구성하는 애너테이션, 요청 및 전송, 응답 기능을 제공하는 유틸리티 클래스  

#### AssertJ
#### JUnit 함께 사용해 가독성을 확 높여주는 라이브러리
Assertion.assertEquals(실제 값, 기댓값)  
➡️ 가독성이 떨어짐  
assertThat(기댓값).isEqualTo(실제 값)  
➡️ 두 값의 구분으로 가독성 증가  

### Rest Assured