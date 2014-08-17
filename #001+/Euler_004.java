// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_004 extends EulerBase
{
	public Euler_004()
	{
		title	= "Largest palindrome product" ;
		problem	= "Problem 4\n"
				+ "Published on 16 November 2001 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "A palindromic number reads the same both ways. The largest palindrome made\n"
				+ "from the product of two 2-digit numbers is 9009 = 91 * 99.\n"
				+ "\n"
				+ "Find the largest palindrome made from the product of two 3-digit numbers.\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 2,	9009	) ),
					new RunSet( "Problem",	new Run( 3,	906609	) )
				} ;
		report	= "Largest palindrome from of %,d digit numbers is %,d" ;
		//TODO: Report the two numbers involved
	}
//----------------------------------------------------------------------------------
//	Answer: 906609 (913x993)
//----------------------------------------------------------------------------------

	//	Only saved for info-sake: the two numbers that produce the palindrom.
	//
	private static long max_i = 0 ;
	private static long max_j = 0 ;

	//	Converts 'n' to a string and checks that characters at opposing ends match.
	//
	private static boolean is_palindrome( long n )
	{
		String s = String.valueOf( n ) ;
		int len = s.length() ;
		for( int i = 0 ; i < len / 2 ; i++ )
			if( s.charAt( i ) != s.charAt( len-i-1 ) )
				return false ;
		return true ;

	}

	//	No attempt at cleverness (if there is any to be had...) just brute all numbers
	//	of the appropriate size looking for the largest palindrome.
	//
	//public static long largest_palindrome( long limit )
	protected long solve( long num_length )
	{
		long lo = (long)Math.pow( 10, num_length-1 ) ;			// e.g. 10, 100
		long hi = (long)Math.pow( 10, num_length   ) - 1 ;		// e.g. 99, 999

		long max_palindrome = 0 ;
		for( long i = lo ; i <= hi ; i++ )
		{
			for( long j = lo ; j <= hi ; j++ )
			{
				long candidate = i * j ;
				if( candidate > max_palindrome && is_palindrome( candidate ) )
				{
					max_palindrome = candidate ;
					max_i = i ;
					max_j = j ;
				}
			}
		}
		return max_palindrome ;
	}
}
