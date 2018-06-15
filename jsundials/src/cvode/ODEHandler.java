package cvode; 

public abstract class ODEHandler
{
	static 
	{
		System.loadLibrary("jniODE");
		// TEMPORARILY FOR MIRCO
		//System.load("/Users/JSundials/jniODE.dylib");
	}

	public ODEHandler ( int neq )
	{
		this.NEQ = neq; 
	}

	//public native int solve( int neq , double[] ic , double t0 , double tmax , int steps , double tolerance);

	public native double[][] solve ( int neq, double t0 , double tmax , int nSteps , double[] ic , double absTol , double resTol );

	
	public abstract int computeDerivative ( double t , double[] y , double[] yp );

	/// proviamo prima cosi, di la dovrebbe essere ydot = computderivatives(t,y) , altrimenti si puoi fare void cD(t,y,ydot) e salvare le cose updated in ydot
	

	private int NEQ;
	public int getNEQ()
	{
		return NEQ;
	}

	/*public void setNEQ( int n )
	{
		this.NEQ = n ; 
	}*/

	
}