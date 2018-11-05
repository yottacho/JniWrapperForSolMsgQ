# JniWrapperForSolMsgQ
JNI구현체의 윈도우 래퍼 작성

간단한 JNI 테크닉 구현 샘플

## 구성
* VisualStudio 2017 (C++)
* Java Development Kit(JDK) 1.8+

## 환경설정
* JDK를 설치합니다. 32비트와 64비트가 모두 필요합니다.
* 환경변수에 `JAVA_HOME`을 셋팅합니다.
* PATH에 `%JAVA_HOME%\bin` 을 추가합니다.
* JavaJNI 폴더의 `run_debug.bat`, `run_release.bat` 파일의 Java 경로를 수정합니다.

## 배포
LoadLibrary() 에서 `java.lang.UnsatisfiedLinkError: Can't find dependent libraries`
오류가 발생하면 [VisualStudil 2015 C++ 재배포 패키지](https://www.microsoft.com/ko-KR/download/details.aspx?id=48145 ) 을 설치합니다.

이 구성요소는 vcruntime140.dll 및 관련 DLL을 포함합니다.

## Release
* 1.0.0.2 2018/11/05 fix method nama
* 1.0.0.1 2018/11/03 시작
