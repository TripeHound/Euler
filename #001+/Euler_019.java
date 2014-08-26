// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_019 extends EulerBase
{
	public Euler_019()
	{
		title	= "Counting Sundays" ;

		problem	= "Problem 19\n"
				+ "\n"
				+ "You are given the following information, but you may prefer to do some\n"
				+ "research for yourself.\n"
				+ "\n"
				+ "o  1 Jan 1900 was a Monday.\n"
				+ "\n"
				+ "o  Thirty days has September,\n"
				+ "   April, June and November.\n"
				+ "   All the rest have thirty-one,\n"
				+ "   Saving February alone,\n"
				+ "   Which has twenty-eight, rain or shine.\n"
				+ "   And on leap years, twenty-nine.\n"
				+ "\n"
				+ "o  A leap year occurs on any year evenly divisible by 4, but not on a century\n"
				+ "   unless it is divisible by 400.\n"
				+ "\n"
				+ "How many Sundays fell on the first of the month during the twentieth\n"
				+ "century (1 Jan 1901 to 31 Dec 2000)?\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Problem",	new Run( 0,	171	) )
				} ;
		report	= "Number of Sundays falling on the 1st of the month during C20 is %2$,d" ;
	}

//----------------------------------------------------------------------------------

	protected long solve( Object input )
		throws NoSolutionException
	{
		int[] days_per_month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ;
		int day_of_week = 2 ; // Tuesday, Jan 1st 1901
		long sundays = 0 ;

		for( int year = 1901 ; year <= 2000 ; year++ )
		{
			//	Handle Februrary
			//
			if( (year % 4 == 0) && ( (year % 100 != 0) || (year % 400 == 0) ) )
				days_per_month[1] = 29 ;
			else
				days_per_month[1] = 28 ;

			for( int month = 0 ; month < 12 ; month++ )
			{
				day_of_week += days_per_month[month] ;
				day_of_week %= 7 ;
				if( day_of_week == 0 )
				{
					sundays++ ;
					//System.out.printf( "01/%02d/%d is a Sunday\n", month+1, year ) ;
				}
			}
		}
		return sundays ;
	}
}
