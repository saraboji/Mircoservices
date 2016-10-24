rem set MAVEN_OPTS=-Xms512m -Xmx750m -XX:MaxPermSize=512m
rem set REPO_HOME=../apache-maven-3.3.9-bin/Repository
set JAVA_HOME=C:\RD\workspace\testarea\jdk8
set M2_HOME=C:\RD\workspace\testarea\apache-maven-3.3.9
set PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;
call mvn -Dmaven.test.skip=true clean
pause