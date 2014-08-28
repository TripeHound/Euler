// vim:ai:ts=4:ic:aw:noet

import java.io.* ;
import java.util.Arrays ;

public class Euler_031 extends EulerBase
{
	public Euler_031()
	{
		title	= "Coin sums" ;

		problem	= "Problem 31\n"
				+ "\n"
				+ "In England the currency is made up of pound, £, and pence, p, and there are\n"
				+ "eight coins in general circulation:\n"
				+ "\n"
				+ "    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).\n"
				+ "\n"
				+ "It is possible to make £2 in the following way:\n"
				+ "\n"
				+ "    1x£1 + 1x50p + 2x20p + 1x5p + 1x2p + 3x1p\n"
				+ "\n"
				+ "How many different ways can £2 be made using any number of coins?\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	11		) ),
					new RunSet( "Problem",	new Run( 200,	Run.UNSPECIFIED	) )
				} ;

		report	= "Number of ways of making %,dp is %,d" ;
	}

//----------------------------------------------------------------------------------

	private static int ways = 0 ;
	private static int depth = 0 ;

	private static void enumerate( int target, int[] coins )
	{
		depth++ ;

		if( coins.length == 1 || target == 0 )
		{
			if( target % coins[0] == 0 )
			{
				//System.out.printf( "%"+depth+"s%dx%d - found\n", "", target/coins[0], coins[0] ) ;
				ways++ ;
			}
			else
				//System.out.printf( "%"+depth+"s%d left-over\n", "", target ) ;
			depth-- ;
			return ;
		}


		for( int i = 0 ; i * coins[0] <= target ; i++ )
		{
			//System.out.printf( "%"+depth+"s%dx%d\n", "", i, coins[0] ) ;
			enumerate( target - i*coins[0], Arrays.copyOfRange( coins, 1, coins.length ) ) ;
		}

		depth-- ;
	}

	protected long solve( long input )
		throws NoSolutionException
	{
		ways = 0 ;
		depth = 0 ;

		enumerate( (int) input, new int[] { 200, 100, 50, 20, 10, 5, 2, 1 } ) ;

		return ways ;
	}
}
