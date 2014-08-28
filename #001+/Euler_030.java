// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_030 extends EulerBase
{
	public Euler_030()
	{
		title	= "Digit fifth powers" ;

		problem	= "Problem 30\n"
				+ "\n"
				+ "Surprisingly there are only three numbers that can be written as the sum of\n"
				+ "fourth powers of their digits:\n"
				+ "\n"
				+ "    1634 = 1^4 + 6^4 + 3^4 + 4^4\n"
				+ "    8208 = 8^4 + 2^4 + 0^4 + 8^4\n"
				+ "    9474 = 9^4 + 4^4 + 7^4 + 4^4\n"
				+ "\n"
				+ "As 1 = 1^4 is not a sum it is not included.\n"
				+ "\n"
				+ "The sum of these numbers is 1634 + 8208 + 9474 = 19316.\n"
				+ "\n"
				+ "Find the sum of all the numbers that can be written as the sum of fifth\n"
				+ "powers of their digits.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 4,		19316	) ),
					new RunSet( "Problem",	new Run( 5,		443839	) )
				} ;

		report	= "Sum of numbers equal to the sum of the %,dth power of their digits is %,d" ;
	}

//----------------------------------------------------------------------------------

	private static int get_limit( long power )
	{
		//	Calculate upper limit (for an m-digit number, the greatest possible
		//	sum is (m*9^n); we want the largest 'm' where this has 'm' digits).
		//
		int max_per_digit 	= (int) Math.pow( 9, power ) ;
		int min_for_m_digits= 10 ;
		int limit 			= 0 ;
		for( int m=1 ; m * max_per_digit > min_for_m_digits ; m++ )
		{
			limit = m * max_per_digit ;
			min_for_m_digits *= 10 ;
		}
		return limit ;

	}

	private static long sum_of_digit_powers( int n, long power )
	{
		long sum = 0 ;
		while( n > 0 )
		{
			sum += Math.pow( n % 10, power ) ;
			n /= 10 ;
		}

		return sum ;
	}
	
	protected long solve( long power )
		throws NoSolutionException
	{
		int limit = get_limit( power ) ;
		long sum = 0 ;

		for( int n = 10 ; n <= limit ; n++ )	//"Sum of digits" -> at least two
		{
			if( n == sum_of_digit_powers( n, power ) )
				sum += n ;
		}

		return sum ;
	}
}
