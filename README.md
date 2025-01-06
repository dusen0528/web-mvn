## 빌드 도구 Maven 
- 소프트웨어 개발에 있어 소스 코드를 실행할 수 있는 애플리케이션으로 만들어주는 도구
- 자동화, 일관성, CI/CD 통합, 코드 컴파일, 테스팅, 호환성, 배포, 패키징 등.. 많은 기능들을 제공
- Maven은 Java의 대표적인 빌드 툴 중 하나이며 **XML**을 사용해 빌드 파일을 기술하며, 중앙 저장소를 이용해 편리한 의존 관계 라이브러리를 관리한다.
- 또한 일관된 디렉토리 구조를 제공하지만 기본적으로 maven에서 제공하지 않는 빌드 과정 추가가 복잡하다
- 플러그인 설정이 상이하거나 장황해질 경우 재사용성 및 확장성이 떨어지는 문제가 있다
<br>

### 설치
``` 
brew install mvn
```
Mac 환경을 사용하고 있기에 Homebrew를 통해 간단히 설치 했다.

또한 Java 11 / Java 21 버전을 기반으로 학습할 예정이다. <br><br>




### 프로젝트 생성

![](https://velog.velcdn.com/images/_inho/post/173e3541-58d2-4e1e-a94c-dc4003133f3c/image.png)

이전 vscode에서 생성할 때와 달리 IntelliJ 툴을 이용하니 직관적으로 바로 Maven 프로젝트를 생성할 수 있었다.

<br><br>
## Maven 프로젝트 구조
![](https://velog.velcdn.com/images/_inho/post/d84f9d6b-c7d0-4e6c-9d34-ab41eeea39c2/image.png)

기본적으로 위와 같은 구조를 하는데 각 디렉토리는 다음과 같은 목적을 가지고 있다.

### src 디렉토리
#### src/main
- 이 디렉토리는 프로젝트의 주요 소스 코드와 리소스를 포함합니다.
#### src/main/java
	•	프로젝트의 주요 Java 소스 코드가 위치합니다.
	•	여기에는 com/nhnacademy 패키지 구조가 있어, 해당 패키지 내에 Java 클래스 파일들이 위치하게 됩니다.
#### src/main/resources
	•	애플리케이션에서 사용되는 리소스 파일들이 위치합니다.
	•	설정 파일, 프로퍼티 파일, XML 파일 등이 이 디렉토리에 저장됩니다.
#### src/test
	• 이 디렉토리는 테스트 관련 코드와 리소스를 포함합니다.
#### src/test/java
	•	단위 테스트를 위한 Java 소스 코드가 위치합니다.
	•	JUnit 테스트 클래스 등이 이 디렉토리에 저장됩니다.
### target 디렉토리
	• 빌드 결과물이 저장되는 디렉토리입니다.
#### target/classes
	•	컴파일된 클래스 파일들이 저장됩니다.
	•	com/nhnacademy 구조는 소스 코드의 패키지 구조를 반영합니다.
#### target/generated-sources
	•	빌드 프로세스 중에 생성된 소스 코드가 저장됩니다.
#### target/maven-archiver
	•	Maven 아카이브 관련 정보가 저장됩니다.
#### target/maven-status
	•	Maven 컴파일 상태 정보가 저장됩니다.
    
<br>

### Pom.xml
Maven의 기본 작업 단위.

Maven이 프로젝트를 빌드하는 데 사용하는 프로젝트 및 구성에 대한 세부 정보가 포함된 XML 파일 



Java 11 환경을 구성하기에 
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.nhnacademy</groupId>
    <artifactId>Web</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <mavn.compiler.release>11</mavn.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.0</version>
            </plugin>
        </plugins>
    </build>
</project>
```
이와 같은 의존성을 추가해줬다.

### POM(Project Object Model) 주요 Tag

- project

	Maven의 XML Namespace를 지정합니다.

- modelVersion

	Maven의 model Version
- groupId
	
    	
        group id
        
- artifactId
		
        artifact id

- name
	
    	project 이름

- url


	프로젝트 정보를 다른 사람들이 프로젝트에 대한 자세한 정보를 찾을 수 있도록 안내

	프로젝트 관련된 문서, 소스코드(git)등 관련된 정보를 제공

- properties

	프로젝트에서 사용할 공통 속성

- dependencies

	프로젝트가 참조하고 있는 라이브러리

<br>
<br>

--- 

## 주요 Maven 명령어

**mvn clean install** : 이전 빌드 결과를 정리하고, 프로젝트를 새로 컴파일, 테스트, 패키징한 후 로컬 저장소에 설치합니다.
**mvn clean package** : 이전 빌드 결과를 정리하고, 프로젝트를 새로 컴파일, 테스트한 후 패키징합니다.
**mvn clean test** : 이전 빌드 결과를 정리하고, 프로젝트를 컴파일한 후 테스트를 실행합니다.

<br><br>

**mvn validate** : 프로젝트 상태 점검 및 필요한 정보와 존재 여부 확인

**mvn compile** : 프로젝트 소스 코드 컴파일

**mvn test** : 컴파일된 소스코드에 대한 단위 테스트 실행

**mvn package** : 컴파일된 코드를 JAR(Java ARchive), WAR(Web Archive) 파일로 패키징

**mvn verify** : 패키지가 품질 기준에 적합한지 검사

**mvn install** : 패키징된 JAR/WAR 파일을 로컬 Maven 저장소에 설치

**mvn site** : 프로젝트에 대한 문서 사이트 생성

**mvn deploy** : 패키징된 JAR/WAR 파일을 원격 저장소에 배포


