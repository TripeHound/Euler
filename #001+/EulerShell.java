// vim:ai:ts=4:ic:aw

import java.io.* ;
import java.lang.reflect.* ;

public class EulerShell extends java.applet.Applet
{
	@SuppressWarnings("unchecked")	//TODO: Use a cast-or-throw version?
	private static EulerBase CreateEuler( String eulerNo )
		throws
			IllegalAccessException,
			ClassNotFoundException,
			NoSuchMethodException,
			InstantiationException,
			InvocationTargetException,
			ClassCastException
	{
		eulerNo = "00" + eulerNo ;
		eulerNo = eulerNo.substring( eulerNo.length() - 3, eulerNo.length() ) ;
		String euler_name = "Euler_" + eulerNo ;
		Class euler_class = Class.forName( euler_name ) ;
		Constructor euler_constructor = euler_class.getConstructor() ;
		return (EulerBase) euler_constructor.newInstance() ;
	}
    public static void main( String[] argv ) 
    {
		for( String arg : argv )
		{
			try
			{
				System.out.println( CreateEuler( arg ).Description ) ;
			}
			catch( Exception ex )
			{
				System.out.println( "Cannot find Euler problem '" + arg + "'" ) ;
			}
		}
    }
}
