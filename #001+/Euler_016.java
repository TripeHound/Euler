// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_016 extends EulerBase
{
	public Euler_016()
	{
		title	= "Power digit sum" ;
		problem = "Problem 16\n"
				+ "Published on Friday, 3rd May 2002, 06:00 pm; Solved by 114274\n"
				+ "\n"
				+ "2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n"
				+ "\n"
				+ "What is the sum of the digits of the number 2^1000?\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 15,	26		),
											new Run( 1,		2		),
											new Run( 2,		4		),
											new Run( 3,		8		),
											new Run( 4,		7		),
											new Run( 5,		5		),
											new Run( 6,		10		),
											new Run( 7,		11		),
											new Run( 8,		13		),
											new Run( 9,		8		),
											new Run( 10,	7		),
											new Run( 11,	14		),
											new Run( 12,	19		),
											new Run( 13,	20		),
											new Run( 14,	22		) ),
					new RunSet( "Problem",	new Run( 1000,	1378	) )
				} ;
		report	= "Digit-sum of 2^%,d is %,d" ;
	}

//----------------------------------------------------------------------------------
//TODO
//	Either use java.math.BigInteger or write my own fully-featured class
//
	private class veryLong
	{
		final long limit = 1000000000000000000L ;
		long[] number = new long[300] ;
		int length = 1 ;

		veryLong( long init )
		{
			number[0] = init ;
			length = 1 ;
		}
		void times2()
		{
			long carry = 0 ;
			for( int i=0 ; i < length ; i++ )
			{
				number[i] *= 2 ;
				number[i] += carry ;
				if( number[i] >= limit )
				{
					number[i] -= limit ;
					carry = 1 ;
				}
				else
					carry = 0 ;
			}
			if( carry != 0 )
			{
				number[length++] = carry ;
			}
			//print();
		}
		void print()
		{
			System.out.printf( "%18d", number[length-1] ) ;
			for( int i = length-2 ; i >= 0 ; i-- )
				System.out.printf( "%018d", number[i] ) ;
			System.out.println() ;
		}
		long sum_digits()
		{
			long sum = 0 ;

			for( int i=0 ; i < length ; i++ )
			{
				sum += Euler_016.sum_digits( number[i] ) ;
			}
			return sum ;
		}
	}
	private static long sum_digits( long number )
	{
		long sum = 0 ;
		while( number > 0 )
		{
			sum += number % 10 ;
			number /= 10 ;
		}
		return sum ;
	}
	protected long solve( long input )
		throws NoSolutionException
	{
		veryLong power = new veryLong( 1 ) ;
		for( long i = 0 ; i < input ; i++ )
		{
			power.times2() ;
			//System.out.printf( "%20d %<16x %d\n", power, power & 0x8000000000000000L ) ;
			//if( power == 0 )
				//throw new RuntimeException() ;
		}
		return power.sum_digits() ;
		//throw new NoSolutionException() ;
	}
}
