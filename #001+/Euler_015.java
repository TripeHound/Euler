// vim:ai:ts=4:ic:aw:noet:noet

import java.io.* ;

public class Euler_015 extends EulerBase
{
	public Euler_015()
	{
		title	= "Lattice paths" ;
		problem = "Problem 15\n"
				+ "Published on 19 April 2002 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "Starting in the top left corner of a 2x2 grid, and only being able to move\n"
				+ "to the right and down, there are exactly 6 routes to the bottom right\n"
				+ "corner:\n"
				+ "\n"
				+ "    +--+--+	  +--+	+	 +--+  +	+  +  +    +  +  +	  +  +	+\n"
				+ "			 |		 |			|		|		   |		  |		 \n"
				+ "    +  +  +	  +  +--+	 +	+		+--+--+    +--+  +	  +  +	+\n"
				+ "			 |			|		|			  |		  |		  |		 \n"
				+ "    +  +  +	  +  +	+	 +	+--+	+  +  +    +  +--+	  +--+--+\n"
				+ "\n"
				+ "How many such routes are there through a 20x20 grid?\n" ;
		runsets = new RunSet[] {
					new RunSet( "Test",		new Run( 2,		6				),
											new Run( 3,		20				),
											new Run( 10,	184756			),
											new Run( 11,	705432			),
											new Run( 12,	2704156			),
											new Run( 13,	10400600		),
											new Run( 14,	40116600		),
											new Run( 15,	155117520		),
											new Run( 16,	601080390		),
											new Run( 17,	2333606220L		) ),
					new RunSet( "Problem",	new Run( 20,	137846528820L	) )
				} ;
//		Test	   0.0978	 Number of routes in a	2 x  2 grid is 6
//				   0.0266	 Number of routes in a	3 x  3 grid is 20
//				   6.3827 ?? Number of routes in a 10 x 10 grid is 184,756
//				  17.4113 ?? Number of routes in a 11 x 11 grid is 705,432
//				 162.5067 ?? Number of routes in a 12 x 12 grid is 2,704,156
//				 321.2261 ?? Number of routes in a 13 x 13 grid is 10,400,600
//				1378.6390 ?? Number of routes in a 14 x 14 grid is 40,116,600
//				5486.9226 ?? Number of routes in a 15 x 15 grid is 155,117,520
//			   19193.0915 ?? Number of routes in a 16 x 16 grid is 601,080,390
//			   52565.9617 ?? Number of routes in a 17 x 17 grid is 2,333,606,220
//	 Problem 3197943.8302 ?? Number of routes in a 20 x 20 grid is 137,846,528,820
		report	= "Number of routes in a %,2d x %<,2d grid is %,d" ;
	}

//----------------------------------------------------------------------------------
//	Originally tried a brute-force method... recursively working away across all
//	nodes in the grid.	This was slow, SLOW, S-L-O-W! (about 50 minutes for 20x20!)
//
//	Was about to try a working-backwards, filling the number of routes to the end
//	(being the sum of the adjacent nodes).	E.g., inverting the problem, ways of
//	getting to the top-left are:
//
//		1..1
//		.
//		1
//
//		1..1..1
//		.  .
//		1..2
//		.
//		1
//
//		1..1..1..1
//		.  .  .
//		1..2..3
//		.
//		1..3.(6)
//		.
//		1
//
//	I then realised that -- twisted 45 degrees -- these form Pascal's triangle,
//	the rows of which are themselves the terms of a binomial expansion: 1, 1-1,
//	1-2-1, 1-3-3-1, 1-4-6-4-1 etc.	Thus you can go directly to the required
//	term by calculating 'nCr', where 'n' is twice the size of the grid, and
//	'r' is the size of the grid.
//
//	Calculating nCr = n! / r!(n-r)! semi-directly (multiplying 'n' down to
//	(n-r+1) together and then dividing by r! was overflowing, so I keep an
//	array of divisors (1..r) and dividing them out as soon as possible.

	private static long routes_from( int x, int y )
	{
		if( x * y == 0 )
			return 1 ;
		return routes_from( x-1, y ) + routes_from( x, y-1 ) ;
	}

	private static long combination( long n, long r )
	{
		long[] divisor = new long[ (int) r ] ;
		for( int i = 0 ; i < r ; i++ )
			divisor[i] = i+1 ;

		long combination = 1 ;
		for( int i = (int)(n - r) + 1 ; i <= n ; i++ )
		{
			combination *= i ;
			for( int j = 0 ; j < r ; j++ )
			{
				if( divisor[j] != 0 && combination % divisor[j] == 0 )
				{
					combination /= divisor[j] ;
					divisor[j] = 0 ;
				}
			}
		}
		for( int i = 0 ; i < r ; i++ )
			if( divisor[i] != 0 )
				System.out.printf( "Left: %d\n", divisor[i] ) ;
		return combination ;
	}
	
	protected long solve( long size )
		throws NoSolutionException
	{
		return combination( 2*size, size ) ;
		//return routes_from( (int)size, (int)size ) ;
	}
}
