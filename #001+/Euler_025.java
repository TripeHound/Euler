// vim:ai:ts=4:ic:aw:noet

import java.io.* ;
import java.math.BigInteger ;

public class Euler_025 extends EulerBase
{
	public Euler_025()
	{
		title	= "1000-digit Fibonacci number" ;

		problem	= "Problem 25\n"
				+ "\n"
				+ "The Fibonacci sequence is defined by the recurrence relation:\n"
				+ "\n"
				+ "    F(n) = F(n-1) + F(n-2), where F(1) = 1 and F(2) = 1.\n"
				+ "\n"
				+ "Hence the first 12 terms will be:\n"
				+ "\n"
				+ "    F(1) = 1\n"
				+ "    F(2) = 1\n"
				+ "    F(3) = 2\n"
				+ "    F(4) = 3\n"
				+ "    F(5) = 5\n"
				+ "    F(6) = 8\n"
				+ "    F(7) = 13\n"
				+ "    F(8) = 21\n"
				+ "    F(9) = 34\n"
				+ "    F(10) = 55\n"
				+ "    F(11) = 89\n"
				+ "    F(12) = 144\n"
				+ "\n"
				+ "The 12th term, F(12), is the first term to contain three digits.\n"
				+ "\n"
				+ "What is the first term in the Fibonacci sequence to contain 1000 digits?\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 3,		12		) ),
					new RunSet( "Problem",	new Run( 1000,	4782	) )
				} ;
		report	= "The Fibonacci number with %,d digits is F(%,d)" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( Object input )
		throws NoSolutionException
	{
		Long limit = (Long) input ;

		BigInteger prev = new BigInteger( "1" ) ;
		BigInteger curr = new BigInteger( "1" ) ;
		long index = 2 ;

		while( curr.toString().length() < limit )
		{
			BigInteger next = curr.add( prev ) ;
			prev = curr ;
			curr = next ;
			index++ ;
		}

		return index ;
	}
}
