// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_028 extends EulerBase
{
	public Euler_028()
	{
		title	= "Number spiral diagonals" ;

		problem	= "Problem 28\n"
				+ "\n"
				+ "Starting with the number 1 and moving to the right in a clockwise direction\n"
				+ "a 5 by 5 spiral is formed as follows:\n"
				+ "\n"
				+ "    21 22 23 24 25 ->\n"
				+ "    20  7  8  9 10\n"
				+ "    19  6  1->2 11\n"
				+ "    18  5  4  3 12\n"
				+ "    17 16 15 14 13\n"
				+ "\n"
				+ "It can be verified that the sum of the numbers on the diagonals is 101.\n"
				+ "\n"
				+ "What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral\n"
				+ "formed in the same way?\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 5,		101	) ),
					new RunSet( "Problem",	new Run( 1001,	Run.UNSPECIFIED	) )
				} ;

		report	= "Diagnoal-sum of a %,d x %<,d spiral is %,d" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( long input )
	{
		long sum = 1 ;
		long number = 1 ;
		for( long i=1 ; i < input ; i++ )
		{
			number += 2*i ;
			sum += number ;
			System.out.printf( "n=%04d  sum=%04d\n", number, sum ) ;
		}
		return sum ;
	}
}
