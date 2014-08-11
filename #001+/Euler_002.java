// vim:ai:ts=4:ic:aw

import java.io.* ;

public class Euler_002 extends java.applet.Applet {
	public static long sum_even_fibonaci( long limit )
	{
		long prior = 1 ;
		long fibonaci = 2 ;
		long sum = 0 ;
		while( fibonaci < limit )
		{
			//System.err.println( fibonaci ) ;
			if( fibonaci % 2 == 0 )
			{
				//System.err.println( "Adding " + fibonaci ) ;
				sum += fibonaci ;
			}
			long next = prior + fibonaci ;
			prior = fibonaci ;
			fibonaci = next ;
		}
		return sum ;
	}

    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = sum_even_fibonaci( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "Sum of even fibonaci numbers below " + limit + " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
