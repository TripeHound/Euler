// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_018 extends EulerBase
{
	public Euler_018()
	{
		title	= "Maximum path sum I" ;
		
		problem	= "Problem 18\n"
				+ "\n"
				+ "By starting at the top of the triangle below and moving to adjacent numbers\n"
				+ "on the row below, the maximum total from top to bottom is 23.\n"
				+ "\n"
				+ "                               >03<\n"
				+ "                             >07< 04\n"
				+ "                            02 >04< 06\n"
				+ "                          08  05 >09< 03\n"
				+ "\n"
				+ "That is, 3 + 7 + 4 + 9 = 23.\n"
				+ "\n"
				+ "Find the maximum total from top to bottom of the triangle below:\n"
				+ "\n"
				+ "                                75\n"
				+ "                              95  64\n"
				+ "                            17  47  82\n"
				+ "                          18  35  87  10\n"
				+ "                        20  04  82  47  65\n"
				+ "                      19  01  23  75  03  34\n"
				+ "                    88  02  77  73  07  63  67\n"
				+ "                  99  65  04  28  06  16  70  92\n"
				+ "                41  41  26  56  83  40  80  70  33\n"
				+ "              41  48  72  33  47  32  37  16  94  29\n"
				+ "            53  71  44  65  25  43  91  52  97  51  14\n"
				+ "          70  11  33  28  77  73  17  78  39  68  17  57\n"
				+ "        91  71  52  38  17  14  91  43  58  50  27  29  48\n"
				+ "      63  66  04  68  89  53  67  30  73  16  69  87  40  31\n"
				+ "    04  62  98  27  23  09  70  98  73  93  38  53  60  04  23\n"
				+ "\n"
				+ "NOTE: As there are only 16384 routes, it is possible to solve this problem\n"
				+ "by trying every route. However, Problem 67, is the same challenge with a\n"
				+ "triangle containing one-hundred rows; it cannot be solved by brute force,\n"
				+ "and requires a clever method! ;o)\n" ;

		runsets	= new RunSet[] {
					new RunSet( "Test",		new Run( test_triangle,		23		) ),
					new RunSet( "Problem",	new Run( problem_triangle,	1074	) )
				} ;

		report	= "Maximum sum path through %,d-row triangle is %,d" ;

		inputClass = long[][].class ;
	}

//----------------------------------------------------------------------------------
	long[][] test_triangle = new long[][]
	{
		new long[] {  3 },
		new long[] {  7,  4 },
		new long[] {  2,  4,  6 },
		new long[] {  8,  5,  9,  3 }
	};
	long[][] problem_triangle = new long[][]
	{
		new long[] { 75 },
		new long[] { 95, 64 },
		new long[] { 17, 47, 82 },
		new long[] { 18, 35, 87, 10 },
		new long[] { 20,  4, 82, 47, 65 },
		new long[] { 19,  1, 23, 75,  3, 34 },
		new long[] { 88,  2, 77, 73,  7, 63, 67 },
		new long[] { 99, 65,  4, 28,  6, 16, 70, 92 },
		new long[] { 41, 41, 26, 56, 83, 40, 80, 70, 33 },
		new long[] { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
		new long[] { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
		new long[] { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
		new long[] { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
		new long[] { 63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
		new long[] {  4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23 }
	};
	protected long reportInput( Object input )
	{
		//TODO inputClass.cast() does not seem to work...
		//long[][] triangle = inputClass.cast( input ) ;
		long[][] triangle = (long[][]) input ;
		return triangle.length ;
	}
	protected long solve( Object input )
		throws NoSolutionException
	{
		long[][] triangle = (long[][]) input ;

		for( int i = triangle.length - 2 ; i >= 0 ; i-- )
		{
			for( int j=0 ; j < triangle[i].length ; j++ )
			{
				triangle[i][j] += Math.max( triangle[i+1][j], triangle[i+1][j+1] ) ;
			}
		}
		return triangle[0][0] ;
	}
}
