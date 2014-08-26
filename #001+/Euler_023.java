// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_023 extends EulerBase
{
	public Euler_023()
	{
		title	= "Non-abundant sums" ;

		problem	= "Problem 23\n"
				+ "\n"
				+ "A perfect number is a number for which the sum of its proper divisors is\n"
				+ "exactly equal to the number. For example, the sum of the proper divisors of\n"
				+ "28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect\n"
				+ "number.\n"
				+ "\n"
				+ "A number n is called deficient if the sum of its proper divisors is less\n"
				+ "than n and it is called abundant if this sum exceeds n.\n"
				+ "\n"
				+ "As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest\n"
				+ "number that can be written as the sum of two abundant numbers is 24. By\n"
				+ "mathematical analysis, it can be shown that all integers greater than 28123\n"
				+ "can be written as the sum of two abundant numbers. However, this upper\n"
				+ "limit cannot be reduced any further by analysis even though it is known\n"
				+ "that the greatest number that cannot be expressed as the sum of two\n"
				+ "abundant numbers is less than this limit.\n"
				+ "\n"
				+ "Find the sum of all the positive integers which cannot be written as the\n"
				+ "sum of two abundant numbers.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Problem",	new Run( 28123,	4179871	) )
				} ;
		report	= "Sum of non-abundant-pairs below %,d is %,d" ;
	}

//----------------------------------------------------------------------------------
	private boolean[] is_abundant ;

	private static boolean is_abundant( int n )
	{
		//	An abundant number is one whose (proper) divisors add up to more than it (if
		//	they add to the number itself, it is perfect; to less, the number is deficient).
		//
		//	To find the divisors, we only consider numbers up to the square-root; when we
		//	find one, we add it and its quotient.  The exceptions are '1' (the number itself
		//	is not a 'proper' divisor) and the number's root if it is a perfect square (the
		//	above process would add it in twice).  We handle these by starting the sum at
		//	one and starting at two; and, for perfect squares, adding the root to the sum
		//	and reducing the limit by one.
		//
		//TODO
		//	Modify Euler #21 to use the same SQRT-technique for speed.
		//

		int sum = 1 ;
		int limit = (int) Math.sqrt( n ) ;

		if( limit * limit == n )
		{
			sum += limit ;
			limit-- ;
		}

		for( int i = 2 ; i <= limit ; i++ )
		{
			if( n % i == 0 )
			{
				sum += i + (n / i) ;
				if( sum > n )
					return true ;
			}
		}

		return false ;
	}

	protected long solve( Object input )
	{
		int limit = ((Long) input).intValue() ;

		is_abundant = new boolean[limit+1] ;

		//	Determine whether all numbers up to the limit are abundant or not
		//
		int n_abundant = 0 ;
		for( int i = 1 ; i <= limit ; i++ )
		{
			is_abundant[i] = is_abundant( i ) ;
			n_abundant++ ;
		}

		//	Squash all abundant ones into one array
		//
		int[] abundant = new int[ n_abundant ] ;
		n_abundant = 0 ;
		for( int i = 1 ; i <= limit ; i++ )
			if( is_abundant( i ) )
				abundant[n_abundant++] = i ;

		//	For all numbers up to the limit, run through each abundant number
		//	in turn.  If what's left is less than that number, then it isn't
		//	a sum of two abundant numbers, so add it to the sum and move on to
		//	the next.  If what's left is ALSO abundant, then the number IS the
		//	sum of two abundant numbers, so move to the next number.  Otherwise,
		//	consider the next abundant number as part of a partial sum.
		//
		long sum = 0 ;
		for( int n = 1 ; n <= limit ; n++ )
		{
			for( int i = 0 ; i < n_abundant ; i++ )
			{
				int left = n - abundant[i] ;
				if( left < abundant[i] )
				{
					sum += n ;
					break ;
				}
				if( is_abundant[left] )
				{
					break ;
				}
			}
		}

		return sum ;
	}
}
