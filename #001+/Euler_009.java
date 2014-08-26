// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_009 extends EulerBase
{
	public Euler_009()
	{
		title	= "Special Pythagorean triplet" ;
		problem	= "Problem 9\n"
				+ "Published on 25 January 2002 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n"
				+ "\n"
				+ "    a^2 + b^2 = c^2\n"
				+ "\n"
				+ "For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.\n"
				+ "\n"
				+ "There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n"
				+ "Find the product a.b.c.\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 12,		60			) ),
					new RunSet( "Problem",	new Run( 1000,		31875000	) )
				} ;
		report	= "The product of the pythagorean triple summing to %,d is %,d" ;
	}
//----------------------------------------------------------------------------------
//	Answer: 
//----------------------------------------------------------------------------------
//----------------------------------------------------------------------------------

	private long a, b, c ;

	//public static long find_pythagorean_triplet( long limit )
	protected long solve( long triplet_sum )
		throws NoSolutionException
	{
		for( a = 1 ; a < triplet_sum ; a++ )		// Limits could be lower
		{
			for( b = 1 ; b < triplet_sum ; b++ )
			{
				c = triplet_sum - a - b ;
				if( a*a + b*b != c*c )
					continue ;
				return a * b * c ;
			}
		}
		throw new NoSolutionException() ;
	}
}
