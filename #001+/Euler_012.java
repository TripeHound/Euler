// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_012 extends EulerBase
{
	public Euler_012()
	{
		title	= "Highly divisible triangular number" ;
		problem	= "Problem 12\n"
				+ "Published on 08 March 2002 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "The sequence of triangle numbers is generated by adding the natural\n"
				+ "numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28\n"
				+ "The first ten terms would be:\n"
				+ "\n"
				+ "    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...\n"
				+ "\n"
				+ "Let us list the factors of the first seven triangle numbers:\n"
				+ "\n"
				+ "     1: 1\n"
				+ "     3: 1,3\n"
				+ "     6: 1,2,3,6\n"
				+ "    10: 1,2,5,10\n"
				+ "    15: 1,3,5,15\n"
				+ "    21: 1,3,7,21\n"
				+ "    28: 1,2,4,7,14,28\n"
				+ "\n"
				+ "We can see that 28 is the first triangle number to have over five divisors.\n"
				+ "\n"
				+ "What is the value of the first triangle number to have over five hundred\n"
				+ "divisors?\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 5,		28			),
											new Run( 8,		36			),
											new Run( 15,	120			),
											new Run( 17,	300			),
											new Run( 19,	528			),
											new Run( 23,	630			),
											new Run( 35,	2016		),
											new Run( 39,	3240		),
											new Run( 47,	5460		),
											new Run( 89,	25200		),
											new Run( 111,	73920		),
											new Run( 127,	157080		),
											new Run( 143,	437580		),
											new Run( 161,	749700		),
											new Run( 167,	1385280		),
											new Run( 191,	1493856		),
											new Run( 239,	2031120		),
											new Run( 319,	2162160		),
											new Run( 479,	17907120	) ),
					new RunSet( "Problem",	new Run( 500,	76576500	) )
				} ;
		report	= "First triangular number with over %,-3d factors is %,d" ;
	}

//----------------------------------------------------------------------------------
//	The "obvious" way of counting factors -- trying every number from 1 to itself
//	was agonizingly slow.  Realising that every factor found is really two (it, and
//	what it leaves behind) means you only have to test up to the square-root.
//----------------------------------------------------------------------------------
//	Another, probably faster, way is to find the prime factors; apparently multiplying
//	together '1+the_exponent' of each prime gives the number of factors... e.g.:
//		72 == 2^3 . 3^2
//	so:
//		        4  .  3 = 12 is the number of factors!
//
//	See: http://www.wikihow.com/Find-How-Many-Factors-Are-in-a-Number       TODO
//

	private static long very_slow_count_factors( long number )
	{
		long count = 0 ;
		for( long i=1 ; i <= number ; i++ )
			if( number % i == 0 )
				count++ ;
		return count ;
	}

	private static long count_factors( long number )
	{
		long count = 0 ;
		for( long i=1 ; i*i <= number ; i++ )
			if( number % i == 0 )
				count += 2 ;
		return count ;
	}

	protected long solve( long min_factors )
		throws NoSolutionException
	{
		long triangle = 1 ;
		long count = 1 ;

//long last = 0, nfac ;
		while( count_factors( triangle ) <= min_factors )
		{
		//if( nfac > last )
		//{
			//last = nfac ;
			//System.out.printf( "%12d has %d factors\n", triangle, nfac ) ;
		//}
			triangle += ++count ;
		}
		return triangle ;
	}
}
