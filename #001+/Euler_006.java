// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_006 extends EulerBase
{
	public Euler_006()
	{
		title	= "Sum square difference" ;
		problem	= "Problem 6\n"
				+ "Published on 14 December 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "The sum of the squares of the first ten natural numbers is,\n"
				+ "\n"
				+ "    1^2 + 2^2 + ... + 10^2 = 385\n"
				+ "\n"
				+ "The square of the sum of the first ten natural numbers is,\n"
				+ "\n"
				+ "    (1 + 2 + ... + 10)^2 = 55^2 = 3025\n"
				+ "\n"
				+ "Hence the difference between the sum of the squares of the first ten\n"
				+ "natural numbers and the square of the sum is 3025 - 385 = 2640.\n"
				+ "\n"
				+ "Find the difference between the sum of the squares of the first one hundred\n"
				+ "natural numbers and the square of the sum.\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	2640		) ),
					new RunSet( "Problem",	new Run( 100,	25164150	) )
				} ;
		report	= "Square-of-the-sum less the sum-of-the-squares up to %,d is %,d" ;
	}
//----------------------------------------------------------------------------------
//	Answer: 25164150
//----------------------------------------------------------------------------------
//	Uses a simple add-up-all-the-numbers-and-their-squares algorthim... I know
//	there's a formula for the sum (1..n) and I'm sure there's one for (1^2..n^2)
//	that could be used.
//----------------------------------------------------------------------------------

	//public static long square_sum_less_sum_squares( long limit )
	protected long solve( long limit )
	{
		long sum = 0 ;
		long sum_of_squares = 0 ;

		for( long i = 1 ; i <= limit ; i++ )
		{
			sum += i ;
			sum_of_squares += i*i ;
		}
		long square_of_sum = sum * sum ;

		return square_of_sum - sum_of_squares ;
	}
}
