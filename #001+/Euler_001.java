// vim:ai:ts=4:ic:aw

import java.io.* ;

public class Euler_001 extends EulerBase
{
	public Euler_001()
	{
		title	= "Multiples of 3 and 5" ;
		problem	= "Problem 1\n"
				+ "Published on 05 October 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "If we list all the natural numbers below 10 that are multiples of 3 or 5,\n"
				+ "we get 3, 5, 6 and 9. The sum of these multiples is 23.\n"
				+ "\n"
				+ "Find the sum of all the multiples of 3 or 5 below 1000." ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	23		) ),
					new RunSet( "Problem",	new Run( 1000,	233168	) ),
					new RunSet( "Curious",	new Run( 10		),
											new Run( 100	),
											new Run( 1000	),
											new Run( 10000	) )
				} ;
		report	= "Count of multiples of 3 or 5 up to %,d is %,d" ;
	}
//----------------------------------------------------------------------------------
//	Method (calculating the sum rather than iterating through all numbers) came
//	from a question on CodeReview.
//----------------------------------------------------------------------------------

	//	Highest multiple of 'factor' that is BELOW 'limit'
	//
	private static long highest_multiple( long limit, long factor )
	{
		limit-- ;
		return limit - ( limit % factor ) ;
	}

	//	Uses 'n(n+1)/2' as the sum of the first 'n' numbers to
	//	sum all multiples of 'factor' upto (and including) 'limit'
	//
	private static long sum_of_multiples( long limit, long factor )
	{
		long count = limit / factor ;
		return factor * count * (count +1) / 2 ;
	}

	//	Finds the maximum multiples of 3, 5 and 15 below 'limit' then the
	//	sums of their multiples.  The answer: the sum of all numbers below
	//	'limit' divisible by 3 or 5 is the sum of the first two less the
	//	the third (=the sum of the numbers divisible by both 3 AND 5 which
	//	otherwise would be included twice).
	//
	//TODO public static long sum_of_3s_and_5s( long limit )
	protected long solve( long limit )
	{
		long max_3	= highest_multiple( limit,	3 ) ;
		long max_5	= highest_multiple( limit,	5 ) ;
		long max_15 = highest_multiple( limit, 15 ) ;
		//System.out.println( "max: " + max_3 + ", " + max_5 + ", " + max_15 ) ;
		long sum_3	= sum_of_multiples( max_3 ,  3 ) ;
		long sum_5	= sum_of_multiples( max_5 ,  5 ) ;
		long sum_15 = sum_of_multiples( max_15, 15 ) ;
		//System.out.println( "sum: " + sum_3 + ", " + sum_5 + ", " + sum_15 ) ;

		return sum_3 + sum_5 - sum_15 ;
	}
}
