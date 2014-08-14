// vim:ai:ts=4:ic:aw

import java.io.* ;

public class Euler_002 extends EulerBase
{
	public Euler_002()
	{
		title	= "Even Fibonacci numbers" ;
		problem	= "Problem 2\n"
				+ "Published on 19 October 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "Each new term in the Fibonacci sequence is generated by adding the previous\n"
				+ "two terms. By starting with 1 and 2, the first 10 terms will be:\n"
				+ "\n"
				+ "    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...\n"
				+ "\n"
				+ "By considering the terms in the Fibonacci sequence whose values do not\n"
				+ "exceed four million, find the sum of the even-valued terms.\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 100,		44		) ),
					new RunSet( "Problem",	new Run( 4000000,	4613732	) )
				} ;
		report	= "Sum of even fibonaci numbers below %,d is %,d\n" ;
	}
//----------------------------------------------------------------------------------
//	Answer: 4613732
//----------------------------------------------------------------------------------
//	Uses a fairly brute-force method: calculating all Fibonaci numbers and only
//	adding those divisible by two.
//
//	An improvement might be to note that -- starting with "1, 2" -- the sequence is
//	"odd, even, odd, odd, even,..." -- i.e. every third number is even -- and so,
//	with a bit of algebra, proceed from even-to-even each time around the loop.
//----------------------------------------------------------------------------------

	//	Run through all fibonaci numbers below 'limit' adding the even ones.
	//
	//public static long sum_even_fibonaci( long limit )
	protected long solve( long limit )
	{
		long prior = 1 ;
		long fibonaci = 2 ;
		long sum = 0 ;
		while( fibonaci < limit )
		{
			if( fibonaci % 2 == 0 )
			{
				sum += fibonaci ;
			}
			long next = prior + fibonaci ;
			prior = fibonaci ;
			fibonaci = next ;
		}
		return sum ;
	}
}
