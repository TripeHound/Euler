// vim:ai:ts=4:ic:aw

import java.io.* ;

public class Euler_007 extends EulerBase
{
	public Euler_007()
	{
		title	= "10,001st prime" ;
		problem	= "Problem 7\n"
				+ "Published on 28 December 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see\n"
				+ "that the 6th prime is 13.\n"
				+ "\n"
				+ "What is the 10,001st prime number?\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 6,		13		) ),
					new RunSet( "Problem",	new Run( 10001,	104743	) )
				} ;
		report	= "The %,dth prime is %,d" ;
	}
//----------------------------------------------------------------------------------
//	Answer: 104743
//----------------------------------------------------------------------------------
//  Very crude: just cycle through odd numbers checking for primeness.
//----------------------------------------------------------------------------------

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

	//public static long find_nth_prime( long n )
	protected long solve( long n )
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
}
