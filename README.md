# boilerplate-maven-21
maven java21 springboot3.5.8

## 실행 방법

### 기본 요구사항
- Java 21
- Maven

### 명령어

### 명령어

#### 1. Clean
이전 빌드 아티팩트를 제거합니다.
```bash
./mvnw clean
```

#### 2. Build (Install)
전체 프로젝트를 빌드하고 로컬 저장소에 설치합니다. (멀티모듈 의존성 해결을 위해 권장)
```bash
./mvnw install
```

#### 3. Run
웹 애플리케이션(`spa` 모듈)을 실행합니다.
```bash
# 루트 디렉토리에서 실행
./mvnw spring-boot:run -pl spa
```


#### 4 kill
lsof -t -i :8080 | xargs kill -9

#### 5. Executable JAR 실행 (Production)
빌드된 JAR 파일을 직접 실행합니다. 포트를 지정할 수 있습니다.

**기본 실행:**
```bash
java -jar spa/target/aia-spa-0.0.1-SNAPSHOT.jar
```

**포트 지정 실행 (예: 9090):**
```bash
java -jar -Dserver.port=9090 spa/target/aia-spa-0.0.1-SNAPSHOT.jar
```
또는
```bash
java -jar spa/target/aia-spa-0.0.1-SNAPSHOT.jar --server.port=9090
```

## 프로젝트 구조

```text
boilerplate-maven-21
├── core (공통 유틸, 로깅)
├── api  (비즈니스 로직, API)
└── spa  (웹 애플리케이션, 실행 가능 JAR)
```

## SBOM
```text
SBOM Generation Configured

The cyclonedx-maven-plugin has been added. Running mvn package will now automatically generate SBOM files in JSON format.

Generated SBOM Location:

Root: target/classes/META-INF/sbom/application.cdx.json
Modules: {module}/target/classes/META-INF/sbom/application.cdx.json
This JSON file contains the full Bill of Materials for your project, suitable for vulnerability analysis.
```

## Swagger UI 연동 완료
```text
spa 모듈에 Swagger UI가 성공적으로 통합되었습니다.

URL: http://localhost:8080/swagger-ui/index.html
구성: springdoc-openapi-starter-webmvc-ui 라이브러리를 사용했으며, OpenApiConfig로 기본 정보를 설정했습니다.
```

## 실행 메커니즘 (Execution Mechanism)

이 프로젝트는 멀티 모듈로 구성되어 있지만, 실행 시에는 **Monolithic Architecture**로 동작합니다.

1.  **구조**: `core`(도메인), `api`(비즈니스 로직), `spa`(웹 진입점) 3개의 모듈로 나뉍니다.
2.  **의존성**: `spa` -> `api` -> `core` 순서로 참조합니다.
3.  **빌드 및 실행**:
    - `spa` 모듈이 최종적으로 모든 라이브러리(`api`, `core` 포함)를 패키징하여 하나의 실행 가능한 JAR(Executable JAR)를 생성합니다.
    - `java -jar` 또는 `mvn spring-boot:run`으로 실행되는 프로세스는 오직 하나(`spa`)입니다.
4.  **동작 흐름**:
    - 웹 요청 -> `spa` (Controller/View) -> `api` (Service) -> `core` (Domain/DTO)
