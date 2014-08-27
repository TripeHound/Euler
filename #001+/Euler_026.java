// vim:ai:ts=4:ic:aw:noet

import java.io.* ;
import java.math.BigInteger ;

public class Euler_026 extends EulerBase
{
	public Euler_026()
	{
		title	= "Reciprocal cycles" ;

		problem	= "Problem 26\n"
				+ "\n"
				+ "A unit fraction contains 1 in the numerator. The decimal representation of\n"
				+ "the unit fractions with denominators 2 to 10 are given:\n"
				+ "\n"
				+ "    1/2  =  0.5\n"
				+ "    1/3  =  0.(3)\n"
				+ "    1/4  =  0.25\n"
				+ "    1/5  =  0.2\n"
				+ "    1/6  =  0.1(6)\n"
				+ "    1/7  =  0.(142857)\n"
				+ "    1/8  =  0.125\n"
				+ "    1/9  =  0.(1)\n"
				+ "    1/10 =  0.1\n"
				+ "\n"
				+ "Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can\n"
				+ "be seen that 1/7 has a 6-digit recurring cycle.\n"
				+ "\n"
				+ "Find the value of d < 1000 for which 1/d contains the longest recurring\n"
				+ "cycle in its decimal fraction part.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 10,	7		) ),
					new RunSet( "Problem",	new Run( 1000,	983		) )
				} ;
		report	= "Longest recurring-cycle for 1/n, where n < %,d is for n=%,d" ;
	}

//----------------------------------------------------------------------------------
//	Given:
//			1/n = 0.xyz(abcde)
//	then:
//			10^3/n = xyz.(abcde)
//	and:
//			10^5.10^3/n = xyzabcde.(abcde)
//	thus:
//			10^5.10^3/n - 10^3/n = 10^3.(10^5 - 1)/n = xyzabcde - xyz	[no fraction]
//
//	Therefore, finding the first '10^j.(10^k - 1)' that is an exact multiple of 'n' will
//	give the number of leading digits ('j') and the cycle-length ('k').
//
//	By examination, the maximum for 'j' is 3 for n=1..9 (1/n = 0.125).  Higher ...

	private static int j, k ;
	private static String fraction ;

	private static int cycle_length( long _n )
	{
		int max_j = 3 ;
		for( long nn = _n ; nn > 0 ; nn /= 10 )
			max_j++ ;
		max_j = 10 ;//TODO

		BigInteger   n = new BigInteger( new Long(_n).toString() ) ;//TODO:Can't be right?!
		BigInteger one = new BigInteger(  "1" ) ;
		BigInteger ten = new BigInteger( "10" ) ;
		BigInteger ten_j ;
		BigInteger ten_k ;
		BigInteger ten_k_1 ;

		for( k = 0 ; true ; k++ )
		{
			ten_k = new BigInteger( "10" ).pow( k ) ;
			if( k != 0 )
				ten_k_1 = ten_k.subtract( one ) ;
			else
				ten_k_1 = one ;

			for( j = 0 ; j <= max_j ; j++ )
			{
				ten_j = new BigInteger( "10" ).pow( j ) ;
				if( ten_j.multiply( ten_k_1 ).mod( n ).bitCount() == 0 )
				{
				/*Debug
					String whole = ten_j.multiply( ten_k ).divide( n ).toString() ;
					while( whole.length() < (j+k) )
						whole = "0" + whole ;
					fraction = String.format( "1/%4d (%3d,%3d): 0.%s(%s)...",
									_n, j, k,
									whole.substring( 0, j ),
									whole.substring( j ) ) ;
					//System.out.println( fraction ) ;
				*/
					return k ;
				}
			}
		}
	}
	protected long solve( long limit )
	{
		int max_cycle = 0 ;
		int longest_n = 0 ;

		for( int n = 1 ; n < limit ; n++ )
		{
			int cycle_length = cycle_length( n ) ;
			if( cycle_length > max_cycle )
			{
				//System.out.println( fraction ) ;
				max_cycle = cycle_length ;
				longest_n = n ;
			}
		}

		return longest_n ;
	}
}
