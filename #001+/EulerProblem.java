// vim:ai:ts=4:ic:aw

import java.io.* ;

public abstract class EulerProblem extends java.applet.Applet {

    public abstract long EulerSolution( long limit ) ;

    public static String Description = "The answer to the Euler problem with limit" ;

    public void AnnounceProblem( long limit )
    {
        System.out.print( Description + " " + limit ) ;
    }

    public void AnnounceAnswer( long answer )
    {
        System.out.println( " is " + answer ) ;
    }

    public void solve( String[] argv )
    {
		for( String s : argv )
		{
			long limit = Integer.parseInt( s ) ;    //TODO Method to override if more than one parameter needed?
			long millis = System.nanoTime() ;
			long answer = EulerSolution( limit ) ;
			millis = System.nanoTime() - millis ;
			AnnounceProblem( limit ) ;
            AnnounceAnswer( answer ) ;
			System.out.println( "Time: " + millis / 1000000.0 ) ;
		}
	}
}

