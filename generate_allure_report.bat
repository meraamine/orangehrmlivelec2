@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=C:\Program Files\Java\jdk-21.0.6
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\Win10\.m2\repository\allure\allure-2.32.2\bin;%path%
allure serve allure-results -h localhost
pause
exit