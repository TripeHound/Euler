// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_026 extends EulerBase
{
	public Euler_026()
	{
		title	= "Reciprocal cycles" ;

		problem	= "Problem 26\n"
				+ "\n"
				+ "A unit fraction contains 1 in the numerator. The decimal representation of\n"
				+ "the unit fractions with denominators 2 to 10 are given:\n"
				+ "\n"
				+ "    1/2  =  0.5\n"
				+ "    1/3  =  0.(3)\n"
				+ "    1/4  =  0.25\n"
				+ "    1/5  =  0.2\n"
				+ "    1/6  =  0.1(6)\n"
				+ "    1/7  =  0.(142857)\n"
				+ "    1/8  =  0.125\n"
				+ "    1/9  =  0.(1)\n"
				+ "    1/10 =  0.1\n"
				+ "\n"
				+ "Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can\n"
				+ "be seen that 1/7 has a 6-digit recurring cycle.\n"
				+ "\n"
				+ "Find the value of d < 1000 for which 1/d contains the longest recurring\n"
				+ "cycle in its decimal fraction part.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	7		) ),
					new RunSet( "Problem",	new Run( 1000,	Run.UNSPECIFIED	) )
				} ;
		report	= "Longest recurring-cycle for 1/n, where n < %,d is for n=%,d" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( Object input )
		throws NoSolutionException
	{
		Long limit = (Long) input ;

		throw new NoSolutionException() ;
	}
}
