// vim:ai:ts=4:ic:aw

import java.io.* ;

public class Euler_001 extends java.applet.Applet {
	public static long highest_multiple( long limit, long factor )
	{
		limit-- ;
		return limit - ( limit % factor ) ;
	}
	public static long sum_of_multiples( long limit, long factor )
	{
		long count = limit / factor ;
		return factor * count * (count +1) / 2 ;
	}
	public static long sum_of_3s_and_5s( long limit )
	{
		long max_3  = highest_multiple( limit,  3 ) ;
		long max_5  = highest_multiple( limit,  5 ) ;
		long max_15 = highest_multiple( limit, 15 ) ;
		//System.out.println( "max: " + max_3 + ", " + max_5 + ", " + max_15 ) ;
		long sum_3  = sum_of_multiples( max_3 ,  3 ) ;
		long sum_5  = sum_of_multiples( max_5 ,  5 ) ;
		long sum_15 = sum_of_multiples( max_15, 15 ) ;
		//System.out.println( "sum: " + sum_3 + ", " + sum_5 + ", " + sum_15 ) ;

		return sum_3 + sum_5 - sum_15 ;
	}
    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = sum_of_3s_and_5s( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "Count of multiples of 3 or 5 up to " + limit + " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 ) ;
		}
	}
}
