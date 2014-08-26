// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_017 extends EulerBase
{
	public Euler_017()
	{
		title	= "Number letter counts" ;
		problem	= "Problem 17\n"
				+ "\n"
				+ "If the numbers 1 to 5 are written out in words: one, two, three, four,\n"
				+ "five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\n"
				+ "\n"
				+ "If all the numbers from 1 to 1000 (one thousand) inclusive were written out\n"
				+ "in words, how many letters would be used? \n"
				+ "\n"
				+ "NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and\n"
				+ "forty-two) contains 23 letters and 115 (one hundred and fifteen) contains\n"
				+ "20 letters. The use of 'and' when writing out numbers is in compliance with\n"
				+ "British usage.\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( 5,		19		) ),
					new RunSet( "Problem",	new Run( 1000,	21124	) )
				} ;
		report	= "Letter count in numbers up to %,d is %,d" ;
	}

//----------------------------------------------------------------------------------

	private static String in_words( long number )
	{
		if( number < 20 ) switch( (int) number )
		{
			case 0:		return "zero" ;
			case 1:		return "one" ;
			case 2:		return "two" ;
			case 3:		return "three" ;
			case 4:		return "four" ;
			case 5:		return "five" ;
			case 6:		return "six" ;
			case 7:		return "seven" ;
			case 8:		return "eight" ;
			case 9:		return "nine" ;
			case 10:	return "ten" ;
			case 11:	return "eleven" ;
			case 12:	return "twelve" ;
			case 13:	return "thirteen" ;
			case 14:	return "fourteen" ;
			case 15:	return "fifteen" ;
			case 16:	return "sixteen" ;
			case 17:	return "seventeen" ;
			case 18:	return "eighteen" ;
			case 19:	return "nineteen" ;
		}
		if( number < 100 )
		{
			String units ;
			if( number % 10 == 0 )
				units = "" ;
			else
				units = "-" + in_words( number % 10 ) ;
			switch( (int)( number / 10 ) )
			{
				case 2:		return "twenty"  + units ;
				case 3:		return "thirty"  + units ;
				case 4:		return "forty"   + units ;
				case 5:		return "fifty"   + units ;
				case 6:		return "sixty"   + units ;
				case 7:		return "seventy" + units ;
				case 8:		return "eighty"  + units ;
				case 9:		return "ninety"  + units ;
			}
		}
		if( number < 1000 )
		{
			if( number % 100 == 0 )
				return in_words( number / 100 ) + " hundred" ;
			else
				return in_words( number / 100 ) + " hundred and " + in_words( number % 100 ) ;
		}
		if( number < 1000000 )
		{
			if( number % 1000 == 0 )
				return in_words( number / 1000 ) + " thousand" ;
			else
				return in_words( number / 1000 ) + " thousand " + in_words( number % 1000 ) ;
		}
		return "TOO BIG!!!" ;
	}
	
	protected long solve( Object input )
		throws NoSolutionException
	{
		long limit = (Long)input ;
		long count = 0 ;
		for( long i = 1 ; i <= limit ; i++ )
		{
			count += in_words( i ).replace( " ", "" ).replace( "-", "" ).length() ;
		}
		return count ;
	}
}
