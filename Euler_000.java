// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//
//	Answer: 
//----------------------------------------------------------------------------------

public class Euler_00? extends java.applet.Applet {
	public static long ?( long limit )
	{
	}
    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = ?( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "??? of " + limit + " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
