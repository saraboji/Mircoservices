for /f "tokens=1-2 delims=:" %%a in ('ipconfig^|find "IPv4"') do set ip=%%b
set ip=%ip:~1%
echo %ip%

for /f %%G in (ip.properties) do (SET remotenode=%%G)
rem set remotenode=%ip%
echo %remotenode%

set JAVA_HOME=C:\RD\workspace\testarea\jdk8
set M2_HOME=C:\RD\workspace\testarea\apache-maven-3.3.9
set PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;

call java -jar ./AvailabilityHostServices/target/AvailabilityHostServices-0.0.1-SNAPSHOT.jar  --eureka.client.serviceUrl.defaultZone=http://%ip%:8761/eureka/,http://%remotenode%:8762/eureka/  --server.port=7111 --spring.data.mongodbport=27017 --eureka.instance.leaseRenewalIntervalInSeconds=1 --eureka.instance.leaseExpirationDurationInSeconds=2