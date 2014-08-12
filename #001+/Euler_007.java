// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//  10001st prime
//  Problem 7
//  Published on 28 December 2001 at 06:00 pm [Server Time]
//
//  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
//  that the 6th prime is 13.
//
//  What is the 10,001st prime number?
//----------------------------------------------------------------------------------
//	Answer: 104743
//----------------------------------------------------------------------------------
//  Very crude: just cycle through odd numbers checking for primeness.
//----------------------------------------------------------------------------------

public class Euler_007 extends java.applet.Applet {

	//	Check whether 'candidate' is prime in a relatively crude way, checking
	//	all odd numbers up to the square-root of the candidate.
	//
	public static boolean is_prime( long candidate )
	{
		if( candidate % 2 == 0 )
			return false ;
		for( long test=3 ; test * test <= candidate ; test += 2 )
		{
			if( candidate % test == 0 )
				return false ;
		}
		return true ;
	}

	//	Finds the next prime after 'prime', which is assumed to be odd.
	//
	public static long next_prime( long prime )
	{
		do {
			prime += 2 ;
		} while( !is_prime( prime ) ) ;
		return prime ;
	}

	public static long find_nth_prime( long n )
	{
        if( n == 1 )
            return 2 ;
        long prime = 3 ;
        for( long i = 2 ; i < n ; i++ )
        {
            prime = next_prime( prime ) ;
        }
        return prime ;
	}

    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = find_nth_prime( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "The " + limit + "th prime is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
