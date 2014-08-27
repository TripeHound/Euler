// vim:ai:ts=4:ic:aw:noet

import java.io.* ;
import java.util.ArrayList ;

public class Euler_027 extends EulerBase
{
	public Euler_027()
	{
		title	= "Quadratic primes" ;

		problem	= "Problem 27\n"
				+ "\n"
				+ "Euler discovered the remarkable quadratic formula:\n"
				+ "\n"
				+ "    n^2 + n + 41\n"
				+ "\n"
				+ "It turns out that the formula will produce 40 primes for the consecutive\n"
				+ "values n = 0 to 39. However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41\n"
				+ "is divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly\n"
				+ "divisible by 41.\n"
				+ "\n"
				+ "The incredible formula  n^2 - 79n + 1601 was discovered, which produces 80\n"
				+ "primes for the consecutive values n = 0 to 79. The product of the\n"
				+ "coefficients, -79 and 1601, is -126479.\n"
				+ "\n"
				+ "Considering quadratics of the form:\n"
				+ "\n"
				+ "    n^2 + an + b, where |a| < 1000 and |b| < 1000\n"
				+ "\n"
				+ "where |n| is the modulus/absolute value of n, e.g. |11| = 11 and |-4| = 4\n"
				+ "\n"
				+ "Find the product of the coefficients, a and b, for the quadratic expression\n"
				+ "that produces the maximum number of primes for consecutive values of n,\n"
				+ "starting with n = 0.\n" ;

		//NOTE
		//	The best answer under 42 is not the example above; it turns out that
		//	negating the 'n' -- 'n^2 - n + 41' -- does one better.

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 42,	-41		) ),
					new RunSet( "Problem",	new Run( 1000,	-59231	) )
				} ;

		report	= "Input %,d is %,d" ;
	}

//----------------------------------------------------------------------------------

	static class Prime
	{
		private static ArrayList<Long> primes ;

		static
		{
			primes = new ArrayList<Long>( 1000 ) ;
			primes.add( 2L ) ;
			primes.add( 3L ) ;
		}

		public static long maxPrime()
		{
			return primes.get( primes.size() - 1 ) ;
		}

		public static boolean isPrime( long n )
		{
			//	If small enough, we know already...
			//
			if( n <= maxPrime() )
				return primes.contains( n ) ;

			//	Otherwise, test divisibility with all existing primes,
			//	bailing-out once we reach the root of the number under test.
			//
			for( long test : primes )
			{
				if( test * test > n )
					break ;
				if( n % test == 0 )
					return false ;
			}

			//	The number IS prime... ensure all primes preceeding it are also
			//	added (the test will add them if they are).
			//
			for( long test = maxPrime() + 2 ; test < n ; test += 2 )
				isPrime( test ) ;

			//	Add the number under test.
			//
			primes.add( n ) ;

			return true ;
		}
	}

	static long longest_sequence = 0 ;
	static long longest_a = 0 ;
	static long longest_b = 0 ;

	private static long sequence_length( long a, long b )
	{
		for( long n=0 ; true ; n++ )
		{
			if( !Prime.isPrime( n*n + a*n + b ) )
				return n ;
		}
	}

	private static void check_sequence_length( long a, long b )
	{
		long sequence_length = sequence_length( a, b ) ;
		if( sequence_length > longest_sequence )
		{
			longest_sequence = sequence_length ;
			longest_a = a ;
			longest_b = b ;
		}
	}

	protected String other_info()
	{
		return String.format( "a=%d, b=%d seq=%d", longest_a, longest_b, longest_sequence ) ;
	}

	protected long solve( long limit )
		throws NoSolutionException
	{
		for( long a = 0 ; a < limit ; a++ )
		{
			for( long b = 1 ; b < limit ; b++ )	// b==0 would be silly
			{
				check_sequence_length( a,  b ) ;
				check_sequence_length( a, -b ) ;
				if( a != 0 )
				{
					check_sequence_length( -a,  b ) ;
					check_sequence_length( -a, -b ) ;
				}
			}
		}
		return longest_a * longest_b ;
	}
}
