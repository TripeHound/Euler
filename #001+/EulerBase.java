// vim:ai:ts=4:ic:aw

import java.io.* ;

public abstract class EulerBase
{
	protected class NoSolutionException extends Exception
	{
	}

	protected class Run
	{
		public static final long UNSPECIFIED = -1 ;	//TODO:Better way needed if answers can be -ve.
		public long input ;
		public long answer ;
		public Run( long input, long answer )
		{
			this.input	= input ;
			this.answer	= answer ;
		}
		public Run( long input )
		{
			this.input	= input ;
			this.answer	= UNSPECIFIED ;
		}
		public boolean isCorrect( long answer )
		{
			return this.answer != UNSPECIFIED && this.answer == answer ;
		}
		public boolean isIncorrect( long answer )
		{
			return this.answer != UNSPECIFIED && this.answer != answer ;
		}
		public String statusStr( long answer )
		{
			return isCorrect(answer) ? "  " : isIncorrect(answer) ? "!!" : "??" ;
		}
	}
	protected class RunSet
	{
		public String name ;
		public Run[] runList ;
		public RunSet( String name, Run... runList )
		{
			this.name = name ;
			this.runList = runList ;
		}
/*		public RunSet( String name, Run[] runList )
		{
			this.name = name ;
			this.runList = runList ;
		}*/
	}
	protected String	title		= "An unspecified Euler problem" ;
	protected String	problem		= "Do something clever with maths" ;
	protected String	report		= "Input=%,d, Answer=%,d" ;
	protected RunSet[]	runsets		= null ;

	protected void showTitle()
	{
		System.out.println( title ) ;
	}
	protected void showProblem()
	{
		System.out.println( problem ) ;
	}
	protected void showReport( long input, long answer )
	{
		System.out.printf( report, input, answer ) ;
	}

	protected abstract long solve( long input )
		throws NoSolutionException ;

	protected void run( RunSet runset )
		//throws NoSolutionException
	{
		String set_name = runset.name ;
		for( Run run : runset.runList )
		{
			System.out.printf( "%"+"10"+"s ", set_name ) ;
			//System.out.printf( "%*s ", set_name_width, set_name ) ;
			//System.out.print( set_name ) ;
			long nanos = System.nanoTime() ;
			try {
				long answer = solve( run.input ) ;
				nanos = System.nanoTime() - nanos ;
				System.out.printf( "%7.4f", nanos / 1000000.0 ) ;
				System.out.print( " " + run.statusStr( answer ) + " " ) ;
				showReport( run.input, answer ) ;
			}
			catch( NoSolutionException ex )
			{//TODO: Override? and/or describe the problem
				System.out.printf( "No solution was found for %d\n", run.input ) ;
			}
			set_name = "" ;
		}
	}
	public void run(/*TODO modes*/)
		//throws NoSolutionException
	{
		System.out.printf( "%s - %s\n", getClass().getName(), title ) ;

		for( RunSet runset : runsets )
		{
			run( runset ) ;
		}
	}
	/*
	public void solve( String[] argv )
	{
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;	//TODO Method to override if more than one parameter needed?
			long millis = System.nanoTime() ;
			long answer = solve( limit ) ;
			millis = System.nanoTime() - millis ;
			showReport( limit, answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 ) ;
		}
	}
	*/
}
