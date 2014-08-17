@echo off
	if /i "%~1" == "-s" call :setEuler %2 && shift && shift
	setlocal

	call jenv

	if /i "%~1" == "-a" goto :buildAll

	if not defined EULER goto :noeuler

	set JAVA=Euler_%EULER%.java
	set BASE=Euler_%EULER%
	set CODE=Euler_%EULER%.class

	if /i "%~1" == "-v" shift && call :editEuler

    call :make
goto :run
	set NEWEST=
	for /f %%a in ('dir /b/od %JAVA% %CODE%') do set NEWEST=%%a

	if not defined NEWEST goto :editEuler

	if %NEWEST% == %JAVA% call :buildEuler
	if not exist %CODE% goto :eof
:run

    echo Running %BASE%
	java EulerShell %EULER% %1 %2 %3 %4 %5 %6 %7 %8 %9

	goto :eof

:buildEuler
	echo Compiling %JAVA%...
	if exist %CODE% del %CODE%
	javac EulerShell.java %JAVA%
	goto :eof

:buildAll
	for %%a in ( Euler_???.java ) do javac %%a
	goto :eof
	
:editEuler
	if not exist %JAVA% (
	    vi -e -s -c ":%%s/!EULER!/%EULER%/" -c ":wq %JAVA%" ..\Euler_000.java
	)
	vi %JAVA% EulerBase.java EulerShell.java
	goto :eof

:make
    for %%a in (*.java) do call :makeFile %%a
    goto :eof

:makeFile
	set JAVA=%1
	set CODE=%~n1.class

	set NEWEST=
	for /f %%a in ('dir /b/od %~n1.*') do set NEWEST=%%a
	if not defined NEWEST goto :eof
	if not %NEWEST% == %JAVA% goto :eof

	echo Compiling %JAVA%...
	if exist %CODE% del %CODE%
	javac %JAVA%
	goto :eof


:setEuler
	set EULER=00%1
	set EULER=%EULER:~-3,3%
	echo Using Euler_%EULER%
	goto :eof

:noEuler
	echo EULER not set - use %0 -s nnn
	goto :eof
