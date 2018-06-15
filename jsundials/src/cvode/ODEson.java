package cvode; 

public class ODEson extends ODEHandler
{

	double x = 2 ; 

	public ODEson(int neq )
	{
		super(neq);
	}


	public int computeDerivative( double t , double[] y , double[] yp  )
	{

		//System.out.println( i ) ; 
		/*System.out.println( "length : " + y.length ); 
		for ( int j = 0 ; j < 3 ; j++ )
		{
			System.out.println( "y"+j+":"+ y[j] ) ; 	
		}*/

		for ( int i = 0 ; i < 3 ; i++ )
		{
				if ( i == 0 )
			{
			//delta = 0.9;
			//delta = 2* y[1] + y[2];
			yp[0] = y[0] + x ; 
			}
			else if (i == 1)
			{
			//delta = 0.6;
			//delta = y[0] + 2*y[2];
			yp[1] = y[1] + x*2; 
			}
			else if (i == 2 )
			{
			//delta = 0.3 ; 
			//delta = y[0] + y[1] + y[2];
			yp[2] = y[2]+ x/3;
			}
		}
		
		return 0; 
	}




	public static void main ( String args[] )
	{
		double[] ic = {1,1,1};
		//int NEQ = 3;
		double t0 = 10;
		double tmax = 20;
		int steps = 5;
		double tolerance = 0.0001;

		ODEHandler ode = new ODEson(3);

		//public native double[][] solve ( int neq, double t0 , double tmax , int nSteps , double[] ic , double absTol , double resTol );
		double[][] ret = ode.solve(ode.getNEQ(),t0,tmax,steps,ic,tolerance,tolerance);

		System.out.println(ret.length);
		System.out.println(ret[0].length);

		for( int i = 0 ; i <  steps ; i++ )
		{
			for( int j = 0 ; j < 4 ; j++ ) 
			{
				System.out.println(ret[i][j]);
			}
		}
	}
}