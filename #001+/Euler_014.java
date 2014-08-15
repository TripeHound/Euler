// vim:ai:ts=4:ic:aw

import java.io.* ;

public class Euler_014 extends EulerBase
{
	public Euler_014()
	{
		title	= "Longest Collatz sequence" ;
		problem	= "Problem 14\n"
				+ "Published on 05 April 2002 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "The following iterative sequence is defined for the set of positive\n"
				+ "integers:\n"
				+ "\n"
				+ "    n -> n/2    (n is even)\n"
				+ "    n -> 3n + 1 (n is odd)\n"
				+ "\n"
				+ "Using the rule above and starting with 13, we generate the following\n"
				+ "sequence:\n"
				+ "\n"
				+ "    13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1\n"
				+ "\n"
				+ "It can be seen that this sequence (starting at 13 and finishing at 1)\n"
				+ "contains 10 terms. Although it has not been proved yet (Collatz Problem),\n"
				+ "it is thought that all starting numbers finish at 1.\n"
				+ "\n"
				+ "Which starting number, under one million, produces the longest chain?\n"
				+ "\n"
				+ "NOTE: Once the chain starts the terms are allowed to go above one million.\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 14,		9		) ),
					new RunSet( "Problem",	new Run( 1000000,	837799	) )
				} ;
		report	= "Longest chain from numbers under %,d comes from %,d" ;
	}

//----------------------------------------------------------------------------------

	private static long longest_chain = 0 ;

	private static long chain_length( long number )
	{
		long steps = 1 ;
		while( number != 1 )
		{
			number = (number % 2 == 0) ? ( number >> 1 ) : ( 3 * number + 1 ) ;
			steps++ ;
		}
		return steps ;
	}

	protected long solve( long limit )
		throws NoSolutionException
	{
		long start_number = 0 ;
		for( long number = 1 ; number < limit ; number++ )
		{
			long length = chain_length( number ) ;
			if( length > longest_chain )
			{
				longest_chain = length ;
				start_number = number ;
			}
		}
		return start_number ;
	}
	protected String other_info()
	{
		return String.format( "%d steps", longest_chain ) ;
	}
}
