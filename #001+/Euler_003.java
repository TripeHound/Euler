// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_003 extends EulerBase
{
	public Euler_003()
	{
		title	= "Largest prime factor" ;
		problem	= "Problem 3\n"
				+ "Published on 02 November 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "The prime factors of 13195 are 5, 7, 13 and 29.\n"
				+ "\n"
				+ "What is the largest prime factor of the number 600851475143 ?\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 13195,			29		) ),
					new RunSet( "Problem",	new Run( 600851475143L,	6857	) )
				} ;
		report	= "Largest prime factor of %,d is %,d" ;
	}
//----------------------------------------------------------------------------------
//	Answer: 6857
//----------------------------------------------------------------------------------
//	Checking for the next prime is fairly brute-force: a seive of Erasmus (?) may
//	be marginally better.
//----------------------------------------------------------------------------------

	//	Remove all factors of 'prime' found in 'n', returning what's left.
	//
	private static long remove_factors_of( long n, long prime )
	{
		//System.err.println( "Remove factors of " + prime + " from " + n ) ;
		while( n % prime == 0 )
			n /= prime ;
		return n ;
	}

	//	Check whether 'candidate' is prime in a relatively crude way, checking
	//	all odd numbers up to the square-root of the candidate.
	//
	private static boolean is_prime( long candidate )
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
	private static long next_prime( long prime )
	{
		do {
			prime += 2 ;
		} while( !is_prime( prime ) ) ;
		return prime ;
	}

	//	Removes factors of each prime in turn from 'n', until the next prime equals 'n'
	//	(if we hit '1'; the last prime was repeated in 'n').  Handle '2' outside the
	//	loop so that next_prime() doesn't have to worry about switching from even to odd.
	//
	//public static long largest_prime_factor( long n )
	protected long solve( long n )
	{
		n = remove_factors_of( n, 2 ) ;
		if( n == 1 )
			return 2 ;
		long prime = 3 ;
		while( prime < n )
		{
			n = remove_factors_of( n, prime ) ;
			if( n == 1 )
				break ;
			prime = next_prime( prime ) ;
		}
		return prime ;
	}
}
