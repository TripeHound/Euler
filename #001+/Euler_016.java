// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_016 extends EulerBase
{
	public Euler_016()
	{
		title	= "Power digit sum" ;
		problem = "Problem 16\n"
				+ "Published on Friday, 3rd May 2002, 06:00 pm; Solved by 114274\n"
				+ "\n"
				+ "2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n"
				+ "\n"
				+ "What is the sum of the digits of the number 2^1000?\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 15,	26		),
											new Run( 1,		1		),
											new Run( 2,		2		),
											new Run( 3,		8		),
											new Run( 4,		7		),
											new Run( 5,		5		),
											new Run( 6,		10		),
											new Run( 7,		11		),
											new Run( 8,		13		),
											new Run( 9,		8		),
											new Run( 10,	7		),
											new Run( 11,	14		),
											new Run( 12,	19		),
											new Run( 13,	20		),
											new Run( 14,	22		) ),
					new RunSet( "Problem",	new Run( 1000,	Run.UNSPECIFIED	) )
				} ;
		report	= "Digit-sum of 2^%,d is %,d" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( long input )
		throws NoSolutionException
	{
		throw new NoSolutionException() ;
	}
}
