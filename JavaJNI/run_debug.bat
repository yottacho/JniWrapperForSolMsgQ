@echo off

set JAVA_HOME_32=C:\Program Files (x86)\Java\jdk1.8.0_162
set JAVA_HOME_64=C:\Program Files\Java\jdk1.8.0_162

echo ---------- 32bit Debug test ----------
"%JAVA_HOME_32%\bin\java.exe" -DTEST_DLL_TARGET=Debug MessageQueueTest

echo ---------- 64bit Debug test ----------
"%JAVA_HOME_64%\bin\java.exe" -DTEST_DLL_TARGET=Debug MessageQueueTest


pause
