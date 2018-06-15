package jida; 

public class DAEson extends DAEHandler
{
	double[][] x = new double[][]{ {0,2,1} , {1,0,2} , {1,1,1} } ;
	boolean[] alg = {false,false,true};

	public DAEson(int neq )
	{
		super(neq);
	}

	public int computeNextStep ( double t , double[] y , double[] yp   , double[] ypp )
	{
		
		//System.out.println(i);
		//System.out.println(y.length);
		/*for ( int j = 0 ; j < 3 ; j++ )
		{
			System.out.println( "y"+j+":"+ y[j] + ",yp"+j+":" + yp[j] ) ; 	
		}*/
		


		/*if ( i == 0 )
		{
			ret = 2 * y[1] + y[2] - yp[0]; 	
		}
		if ( i == 1 )
		{
			ret = y[0] + 2 * y[2] - yp[1];
		}
		if ( i == 2 )
		{
			ret = y[0] + y[1] + y[2];
		}*/

		/*for ( int j = 0 ; j < getNEQ() ; j++ )
		{
			ret = ret + (x[i][j] * y[j]) ;
			
		}

		if ( !alg[i] )
		{
			ret = ret - yp[i] ;
		}*/
		//System.out.println("Ciao ciccio");

		for ( int i = 0 ; i < getNEQ() ; i++)
		{
			//System.out.println("Ciao bello");
			ypp[i] = 0 ; 
			for ( int j = 0 ; j < getNEQ() ; j++ )
			{
				ypp[i] = ypp[i] + (x[i][j] * y[j]);
			}

			if ( !alg[i] )
			{
				ypp[i] = ypp[i] - yp[i] ; 
			}
		}

		/*if ( i == 0 )
		{
			ret = 2 * y[1] + y[2] - yp[0]; 	
		}
		if ( i == 1 )
		{
			ret = y[0] + 2 * y[2] - yp[1];
		}
		if ( i == 2 )
		{
			ret = y[0] + y[1] + y[2];
		}*/
		//System.out.println("Java: "+ret+","+i);
		return 0; 
	}



	public static void main ( String args[] )
	{
		double[] ic = {0.3333,0.3333,-0.6666};
		double[] icp = {0,-1,0};
		
		double t0 = 0 ; 
		double tmax = 11; 
		int steps = 12; 
		double tolerance = 0.0001; 
		

		/*for ( int j = 0 ; j < 3 ; j++ )
		{
			System.out.println( "ic"+j+":"+ ic[j] + ",icp"+j+":" + icp[j] ) ; 	
		}*/

		DAEHandler dae = new DAEson(3);
	

		double[][] ret = dae.solve(dae.getNEQ(), t0 , tmax , steps , ic , icp , tolerance , tolerance); 
		 // .solve(NEQ , ic , icp , t0 , tmax , steps , tolerance );

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