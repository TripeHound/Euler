// vim:ai:ts=4:ic:aw

import java.io.* ;

//----------------------------------------------------------------------------------
//	Sum square difference
//	Problem 6
//	Published on 14 December 2001 at 06:00 pm [Server Time]
//
//	The sum of the squares of the first ten natural numbers is,
//
//		1^2 + 2^2 + ... + 10^2 = 385
//
//	The square of the sum of the first ten natural numbers is,
//
//		(1 + 2 + ... + 10)^2 = 55^2 = 3025
//
//	Hence the difference between the sum of the squares of the first ten
//	natural numbers and the square of the sum is 3025 - 385 = 2640.
//
//	Find the difference between the sum of the squares of the first one hundred
//	natural numbers and the square of the sum.
//----------------------------------------------------------------------------------
//	Answer: 25164150
//----------------------------------------------------------------------------------
//	Uses a simple add-up-all-the-numbers-and-their-squares algorthim... I know
//	there's a formula for the sum (1..n) and I'm sure there's one for (1^2..n^2)
//	that could be used.
//----------------------------------------------------------------------------------

public class Euler_006 extends java.applet.Applet {

	public static long square_sum_less_sum_squares( long limit )
	{
		long sum = 0 ;
		long sum_of_squares = 0 ;

		for( long i = 1 ; i <= limit ; i++ )
		{
			sum += i ;
			sum_of_squares += i*i ;
		}
		long square_of_sum = sum * sum ;

		return square_of_sum - sum_of_squares ;
	}

    public static void main( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;
			long millis = System.nanoTime() ;
			long answer = square_sum_less_sum_squares( limit ) ;
			millis = System.nanoTime() - millis ;
			System.out.println( "Square-of-the-sum less the sum-of-the-squares upto " + limit
								+ " is " + answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 + "ms" ) ;
		}
	}
}
