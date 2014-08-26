// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_021 extends EulerBase
{
	public Euler_021()
	{
		title	= "Amicable numbers" ;

		problem	= "Problem 21\n"
				+ "\n"
				+ "Let d(n) be defined as the sum of proper divisors of n (numbers less than n\n"
				+ "which divide evenly into n).\n"
				+ "\n"
				+ "If d(a) = b and d(b) = a, where a <> b, then a and b are an amicable pair\n"
				+ "and each of a and b are called amicable numbers.\n"
				+ "\n"
				+ "For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,\n"
				+ "55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,\n"
				+ "71 and 142; so d(284) = 220.\n"
				+ "\n"
				+ "Evaluate the sum of all the amicable numbers under 10000.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 1000,	504		) ),
					new RunSet( "Problem",	new Run( 10000,	31626	) )
				} ;
		report	= "Sum of amicable numbers below %,d is %,d" ;
	}

//----------------------------------------------------------------------------------

	private static long sum_divisors( long number )
	{
		long sum = 0 ;

		for( long i = 1 ; i <= number / 2 ; i++ )
			if( number % i == 0 )
				sum += i ;

		return sum ;
	}
	
	private static boolean is_amicable( long number )
	{
		long candidate = sum_divisors( number ) ;
		if( candidate != number && sum_divisors( candidate ) == number )
			return true ;

		return false ;
	}

	protected long solve( Object input )
		//throws NoSolutionException
	{
		Long limit = (Long) input ;
		long sum = 0 ;

		for( long i = 1 ; i < limit ; i++ )
		{
			if( is_amicable( i ) )
				sum += i ;
		}

		return sum ;
	}
}
