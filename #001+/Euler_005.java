// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//	Smallest multiple
//	Problem 5
//	Published on 30 November 2001 at 06:00 pm [Server Time]
//
//	2520 is the smallest number that can be divided by each of the numbers from
//	1 to 10 without any remainder.
//
//	What is the smallest positive number that is evenly divisible by all of the
//	numbers from 1 to 20?
//
//	Answer: 
//----------------------------------------------------------------------------------

public class Euler_005 extends java.applet.Applet {
	public static long new_factors( long n )
	{
		System.err.print( n + ": " ) ;
		for( long i = 2 ; i < n-1 ; i++ )
			while( n % i == 0 )
				n /= i ;
		System.err.println( n ) ;
		return n ;
	}
	public static long smallest_multiple_up_to( long limit )
	{
		long answer = 1 ;
		for( long i = 2 ; i < limit ; i++ )
		{
			answer *= new_factors( i ) ;
		}
		return answer ;
	}
    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = smallest_multiple_up_to( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "Smallest multiple of 1.." + limit + " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
