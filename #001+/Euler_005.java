// vim:ai:ts=4:ic:aw:noet
// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_005 extends EulerBase
{
	public Euler_005()
	{
		title	= "Smallest multiple" ;
		problem	= "Problem 5\n"
				+ "Published on 30 November 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "2520 is the smallest number that can be divided by each of the numbers from\n"
				+ "1 to 10 without any remainder.\n"
				+ "\n"
				+ "What is the smallest positive number that is evenly divisible by all of the\n"
				+ "numbers from 1 to 20?\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	2520		) ),
					new RunSet( "Problem",	new Run( 20,	232792560	) )
				} ;
		report	= "Smallest multiple of 1 x 2 x ... x %,d is %,d" ;
	}
//----------------------------------------------------------------------------------
//	Answer: 232792560
//----------------------------------------------------------------------------------
//	Works by determining "new" factors of each number; an alternative might be to
//	(prime) factorise each number and add up the minimal powers needed.
//----------------------------------------------------------------------------------

	//	Determines the "new" factors needed for 'n' by eliminating the new factors
	//	of all numbers below it (needs to be only the new factors: '6' can be fully
	//	eliminated since both '2' and '3' divide it and are both "new"; however,
	//	for '8', we need a new factor of '2': although both '4' and '2' divide into
	//	it, '4' added a factor of '2' and 'borrowed' one from '2': the '2' can only
	//	be used twice.
	//
	private static long new_factors( long n )
	{
		//System.err.print( n + ": " ) ;
		for( long i = n-1 ; i > 1 ; i-- )
			if( n % i == 0 )
				n /= new_factors(i) ;
		//System.err.println( n ) ;
		return n ;
	}

	//	Multiply together all the "new" factors of the numbers from 2 to 'limit'.
	//
	//public static long smallest_multiple_up_to( long limit )
	protected long solve( long limit )
	{
		long answer = 1 ;
		for( long i = 2 ; i <= limit ; i++ )
		{
			answer *= new_factors( i ) ;
		}
		return answer ;
	}
}
