// vim:ai:ts=4:ic:aw:noet

import java.io.* ;
import java.lang.reflect.* ;

public class EulerShell extends java.applet.Applet
{
	//TODO: move to EulerBase...
	@SuppressWarnings("unchecked")	//TODO: Use a cast-or-throw version?
	private static EulerBase CreateEuler( int eulerNo )
		throws
			IllegalAccessException,
			ClassNotFoundException,
			NoSuchMethodException,
			InstantiationException,
			InvocationTargetException,
			ClassCastException
	{
		String euler_name = String.format( "Euler_%03d", eulerNo ) ;
		Class euler_class = Class.forName( euler_name ) ;
		Constructor euler_constructor = euler_class.getConstructor() ;
		return (EulerBase) euler_constructor.newInstance() ;
	}
	private static void runProblem( int euler_no )
	{
		EulerBase eulerProblem = null ;
		try
		{
			eulerProblem = CreateEuler( euler_no ) ;
		}
		catch( Exception ex )
		{
			System.out.printf( "Cannot find Euler problem '%d': %s\n", euler_no, ex.getMessage() ) ;
		}
		try
		{
			eulerProblem.run() ;
		}
		catch( Exception ex )
		{
			System.out.printf( "Error with Euler problem '%d': %s\n", euler_no, ex.getMessage() ) ;
		}
	}

	public static void main( String[] argv ) 
	{
		for( String arg : argv )
		{
			if( arg.equals( "-t" ) )
			{
				EulerBase.titles_only = true ;
			}
			else if( arg.contains( "-" ) )
			{
				String[] parts = arg.split( "-" ) ;
				if( parts.length != 2 )
					throw new RuntimeException( "Invalid command: '" + arg + "'" ) ;
				int lo = Integer.parseInt( parts[0] ) ;
				int hi = Integer.parseInt( parts[1] ) ;
				for( int i = lo ; i <= hi ; i++ )
					runProblem( i ) ;
			}
			else
				runProblem( Integer.parseInt( arg ) ) ;
		}
	}
}
