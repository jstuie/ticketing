
## 1. Gradle Multi Module 구성

Gradle Multi Module  


* 외부에 제공될 API인 admerce-api 모듈
* 도메인을 담은 admerce-core 모듈


## 2. Spring Rest Docs 설정

Rest Docs로 문서(html)가 만들어지면 ```build/asciidoc/html5/```에 생성됨  
생성된 문서를 ```src/main/resources/static/docs```로 복사함  
  
스프링부트는 ```src/main/resources/static/``` 아래에 있는 정적 파일(html/css/js/image)는 자동으로 호스팅해줌  
  
예를 들어 ```src/main/resources/static/docs/index.html```이 있다면, **localhost:8080/docs/index.html 혹은 도메인/docs/index.html로 접속하면 문서를 볼수있음**.  
  
## 3. 테스트 코드 작성


> Rest Docs는 Controller 테스트 코드를 기반으로 문서를 생성.  

### 문서 생성 목록

Spring Rest Docs 테스트 코드에 별다른 코드를 추가하지 않는 경우에 자동 생성되는 asciidoc 파일들은 좌측이고, ```requestParameters```, ```requestFields```, ```responseFields``` 등등을 테스트 코드에 추가함으로 생성되는 asciidoc 은 우측입니다.

| 기본 생성             | 테스트코드에 따라 추가 생성    |
|---------------------|-------------------------|
| curl-request.adoc   | response-fields.adoc    |
| http-request.adoc   | request-parameters.adoc |
| httpie-request.adoc | request-parts.adoc      |
| http-response.adoc  | path-parameters.adoc    |
| request body        | request-parts.adoc      |
| response body       |                         |



### 참고 내용

* [공식 샘플 코드](https://github.com/spring-projects/spring-restdocs/tree/v2.0.1.RELEASE/samples)
* [공식 문서](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/#customizing-requests-and-responses)