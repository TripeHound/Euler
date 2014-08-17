// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_010 extends EulerBase
{
	public Euler_010()
	{
		title	= "Summation of primes" ;
		problem	= "Problem 10\n"
				+ "Published on 08 February 2002 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n"
				+ "\n"
				+ "Find the sum of all the primes below two million.\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,		17				) ),
					new RunSet( "Problem",	new Run( 2000000,	142913828922L	) )
				} ;
		report	= "The sum of all primes below %,d is %,d" ;
	}

//----------------------------------------------------------------------------------

	//TODO: Move some of these recurring functions into a utility class...

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

	protected long solve( long limit )
	{
		long sum = 2 ;		// First prime
		long prime = 3 ;	// Odd ones onward...

		while( prime < limit )
		{
			sum += prime ;
			prime = next_prime( prime ) ;
		}

		return sum ;
	}
}
