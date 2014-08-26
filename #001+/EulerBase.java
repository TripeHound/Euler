// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public abstract class EulerBase
{
	protected class NoSolutionException extends Exception
	{
	}

	protected class Run
	{
		public static final long UNSPECIFIED = -1 ;	//TODO:Better way needed if answers can be -ve.
		
		public Object	input ;
		public long		answer ;

		public Run( long input, long answer )
		{
			this.input	= input ;
			this.answer	= answer ;
		}
		public Run( Object input, long answer )
		{
			this.input	= input ;
			this.answer	= answer ;
		}
		public Run( long input )
		{
			this.input	= input ;
			this.answer	= UNSPECIFIED ;
		}
		public Run( Object input )
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
	}
	protected String	title		= "An unspecified Euler problem" ;
	protected String	problem		= "Do something clever with maths" ;
	protected String	report		= "Input=%,d, Answer=%,d" ;
	protected RunSet[]	runsets		= null ;
	protected Class		inputClass	= Long.class ;

	protected String other_info() { return null ; }//TODO:Improve

	protected void showTitle()
	{
		System.out.println( title ) ;
	}
	protected void showProblem()
	{
		System.out.println( problem ) ;
	}
	protected long reportInput( Object input )
	{
		return (Long) input ;
	}
	protected void showReport( Object input, long answer )
	{
		//System.out.printf( "::%s::\n", input.getClass().getName() ) ;
		//System.out.printf( "::%s::\n", inputClass.getName() ) ;
		System.out.printf( report, reportInput( input ), answer ) ;
		//System.out.printf( report, reportInput( inputClass.cast( input ) ), answer ) ;
		String other = other_info() ;
		if( other != null )
			System.out.printf( " (%s)\n", other_info() ) ;
		else
			System.out.println() ;
	}

	protected abstract long solve( Object input )
		throws NoSolutionException ;

	protected void run( RunSet runset )
		//throws NoSolutionException
	{
		String set_name = runset.name ;
		for( Run run : runset.runList )
		{
			System.out.printf( "%"+"10"+"s ", set_name ) ;
			long nanos = System.nanoTime() ;
			try {
				long answer = solve( run.input ) ;
				nanos = System.nanoTime() - nanos ;
				System.out.printf( "%8.4f", nanos / 1000000.0 ) ;
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
	public static boolean titles_only = false ;	//TODO: get/setters?
	public void run()
		//throws NoSolutionException
	{
		System.out.printf( "%s - %s\n", getClass().getName(), title ) ;

		if( titles_only )
			return ;
		for( RunSet runset : runsets )
		{
			run( runset ) ;
		}
	}
}
