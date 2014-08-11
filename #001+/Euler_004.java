// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//	Largest palindrome product
//	Problem 4
//	Published on 16 November 2001 at 06:00 pm [Server Time]
//
//	A palindromic number reads the same both ways. The largest palindrome made
//	from the product of two 2-digit numbers is 9009 = 91 * 99.
//
//	Find the largest palindrome made from the product of two 3-digit numbers.
//
//	Answer: 906609 (913x993)
//----------------------------------------------------------------------------------

public class Euler_004 extends java.applet.Applet {
	public static long max_i = 0 ;
	public static long max_j = 0 ;

	public static boolean is_palindrome( long n )
	{
		String s = String.valueOf( n ) ;
		int len = s.length() ;
		for( int i = 0 ; i < len / 2 ; i++ )
			if( s.charAt( i ) != s.charAt( len-i-1 ) )
				return false ;
		return true ;

	}
	public static long largest_palindrome( long limit )
	{
		long lo = (long)Math.pow( 10, limit-1 ) ;
		long hi = (long)Math.pow( 10, limit   ) - 1 ;
		//System.err.println( lo + "..." + hi ) ;

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
    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = largest_palindrome( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "Largest palindrome from of " + limit
								+ " digit numbers is " + answer
								+ " (" + max_i + "x" + max_j + ")" ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
