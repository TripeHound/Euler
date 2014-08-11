// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//	Largest prime factor
//	Problem 3
//	Published on 02 November 2001 at 06:00 pm [Server Time]
//
//	The prime factors of 13195 are 5, 7, 13 and 29.
//
//	What is the largest prime factor of the number 600851475143 ?
//
//	Answer: 6857
//----------------------------------------------------------------------------------

public class Euler_003 extends java.applet.Applet {
	public static long remove_factors_of( long n, long prime )
	{
		while( n % prime == 0 )
			n /= prime ;
		return n ;
	}
	public static boolean is_prime( long prime )
	{
		if( prime % 2 == 0 )
			return false ;
		for( long test=3 ; test * test < prime ; test += 2 )
		{
			if( prime % test == 0 )
				return false ;
		}
		return true ;
	}
	public static long next_prime( long prime )
	{
		do {
			prime += 2 ;
		} while( !is_prime( prime ) ) ;
		return prime ;
	}
	public static long largest_prime_factor( long n )
	{
		long prime = 2 ;
		n = remove_factors_of( n, prime ) ;
		if( n == 1 )
			return prime ;
		prime = 3 ;
		while( prime < n )
		{
			n = remove_factors_of( n, prime ) ;
			if( n == 1 )
				return prime ;
			prime = next_prime( prime ) ;
		}
		return n ;
	}
    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Long.parseLong( s ) ;
			long millis = System.nanoTime() ;
			long answer = largest_prime_factor( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "Largest prime factor of " + limit + " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
