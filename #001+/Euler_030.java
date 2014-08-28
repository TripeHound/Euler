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
					new RunSet( "Test",		new Run( 4,		19316			) ),
					new RunSet( "Problem",	new Run( 5,		Run.UNSPECIFIED	) )
				} ;

		report	= "Sum of numbers which equal the %,dth power of their digits is %,d" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( long input )
		throws NoSolutionException
	{
		throw new NoSolutionException() ;
	}
}
