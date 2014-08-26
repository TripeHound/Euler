// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_024 extends EulerBase
{
	public Euler_024()
	{
		title	= "Lexicographic permutations" ;

		problem	= "Problem 24\n"
				+ "\n"
				+ "A permutation is an ordered arrangement of objects. For example, 3124 is\n"
				+ "one possible permutation of the digits 1, 2, 3 and 4. If all of the\n"
				+ "permutations are listed numerically or alphabetically, we call it\n"
				+ "lexicographic order. The lexicographic permutations of 0, 1 and 2 are:\n"
				+ "\n"
				+ "    012   021   102   120   201   210\n"
				+ "\n"
				+ "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3,\n"
				+ "4, 5, 6, 7, 8 and 9?\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 1,			 123456789		),
											new Run( 2,			 123456798		),
											new Run( 3,			 123456879		),
											new Run( 3628799,	9876543201L		),
											new Run( 3628800,	9876543210L		) ),
					new RunSet( "Problem",	new Run( 1000000,	2783915460L		) )
				} ;

		report	= "The %,dth permutation is %,d" ;
	}

//----------------------------------------------------------------------------------
//	Algorithm taken from http://en.wikipedia.org/wiki/Permutations#Generation_in_lexicographic_order
//
	protected long solve( Object input )
		throws NoSolutionException
	{
		Long index = (Long) input ;

		char[] perm = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' } ;
		int length = perm.length ;
		int l, k ;

		for( int i = 1 ; i < index ; i++ )
		{
			//	Find the last place where the second digit is greater than the first
			//
			for( k = length-2 ; k >= 0 ; k-- )
			{
				if( perm[k] < perm[k+1] )
					break ;
			}
			if( k < 0 )
				throw new NoSolutionException() ;

			//	Find the last digit greater than the 'k'th found above
			//
			for( l = length-1 ; l > k ; l-- )
			{
				if( perm[k] < perm[l] )
					break ;
			}
			if( l == k )
				throw new NoSolutionException() ;

			//	Swap the 'k'th and 'l'th digits
			//
			char temp = perm[k] ;
			perm[k] = perm[l] ;
			perm[l] = temp ;

			//	Reverse digits from 'k+1' to the end.  This involves swapping
			//	half that number (if odd, the middle one remains the same).
			//
			int to_swap = ( length - (k+1) ) / 2 ;
			for( int j = 0 ; j < to_swap ; j++ )
			{
				temp = perm[k+1+j] ;
				perm[k+1+j] = perm[length-1-j] ;
				perm[length-1-j] = temp ;
			}
		}

		return Long.parseLong( new String( perm ) ) ;
	}
}
