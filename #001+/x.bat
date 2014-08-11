@echo off
	if /i "%~1" == "-s" call :setEuler %2 && shift && shift
	setlocal

	if not defined EULER goto :noeuler

	set JAVA=Euler_%EULER%.java
	set BASE=Euler_%EULER%
	set CODE=Euler_%EULER%.class

	if /i "%~1" == "-v" shift && call :editEuler

	set NEWEST=
	for /f %%a in ('dir /b/od %JAVA% %CODE%') do set NEWEST=%%a

	if not defined NEWEST goto :editEuler

	if %NEWEST% == %JAVA% call :buildEuler
	if not exist %CODE% goto :eof

	java %BASE% %1 %2 %3 %4 %5 %6 %7 %8 %9

	goto :eof

:buildEuler
	echo Compiling %JAVA%...
	if exist %CODE% del %CODE%
	javac %JAVA%
	goto :eof
	
:editEuler
	if not exist %JAVA%	copy ..\Euler_000.java %JAVA%
	vi %JAVA%
	goto :eof

:setEuler
	set EULER=00%1
	set EULER=%EULER:~-3,3%
	echo Using Euler_%EULER%
	goto :eof

:noEuler
	echo EULER not set - use %0 -s nnn
	goto :eof
