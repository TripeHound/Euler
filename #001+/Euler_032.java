// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_032 extends EulerBase
{
	public Euler_032()
	{
		title	= "Pandigital products" ;

		problem	= "Problem 32\n"
				+ "\n"
				+ "We shall say that an n-digit number is pandigital if it makes use of all\n"
				+ "the digits 1 to n exactly once; for example, the 5-digit number, 15234, is\n"
				+ "1 through 5 pandigital.\n"
				+ "\n"
				+ "The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing\n"
				+ "multiplicand, multiplier, and product is 1 through 9 pandigital.\n"
				+ "\n"
				+ "Find the sum of all products whose multiplicand/multiplier/product identity\n"
				+ "can be written as a 1 through 9 pandigital.\n"
				+ "\n"
				+ "HINT: Some products can be obtained in more than one way so be sure to only\n"
				+ "include it once in your sum.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Problem",	new Run( 0,	Run.UNSPECIFIED	) )
				} ;

		report	= "Sum of all pan-digital products is %2$,d" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( long input )
		throws NoSolutionException
	{
		return 99 ;
	}
}
