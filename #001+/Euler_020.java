// vim:ai:ts=4:ic:aw:noet

import java.io.* ;
import java.math.BigInteger ;

public class Euler_020 extends EulerBase
{
	public Euler_020()
	{
		title	= "Factorial digit sum" ;

		problem	= "Problem 20\n"
				+ "\n"
				+ "n! means n x (n - 1) x ... x 3 x 2 x 1\n"
				+ "\n"
				+ "For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,\n"
				+ "and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.\n"
				+ "\n"
				+ "Find the sum of the digits in the number 100!\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	27		) ),
					new RunSet( "Problem",	new Run( 100,	648		) )
				} ;

		report	= "Sum of digits in %,d! is %,d" ;
	}

//----------------------------------------------------------------------------------

	private static long sum_digits( BigInteger number )
	{
		long sum = 0 ;
		BigInteger ten = new BigInteger( "10" ) ;
		BigInteger zero = new BigInteger( "0" ) ;

		while( number.compareTo( zero ) > 0 )
		{
			sum += number.mod( ten ).longValue() ;
			number = number.divide( ten ) ;
		}

		return sum ;
	}

	protected long solve( Object input )
		throws NoSolutionException
	{
		Long limit = (Long) input ;
		BigInteger factorial = new BigInteger( "1" ) ;
		BigInteger term = new BigInteger( "2" ) ;
		BigInteger one = new BigInteger( "1" ) ;

		for( long i = 2 ; i <= limit ; i++ )
		{
			factorial = factorial.multiply(  term ) ;
			term = term.add( one ) ;
		}
		return sum_digits( factorial ) ;
	}
}
