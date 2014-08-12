// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//  Special Pythagorean triplet
//  Problem 9
//  Published on 25 January 2002 at 06:00 pm [Server Time]
//  A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//      a^2 + b^2 = c^2
//
//  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//  Find the product abc.
//----------------------------------------------------------------------------------
//	Answer: 
//----------------------------------------------------------------------------------
//----------------------------------------------------------------------------------

public class Euler_009 extends java.applet.Applet
{
	public static long find_pythagorean_triplet( long limit )
	{
	}

    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = find_pythagorean_triplet( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "??? of " + limit + " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
