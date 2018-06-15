package jida; 

public abstract class DAEHandler
{
	static
	{
		System.loadLibrary("jniDAE");
	}

	public DAEHandler ( int neq )
	{
		this.NEQ = neq; 
	}

	//public native int solve ( int neq , double[] ic , double[] icp , double t0 , double tmax , int tsteps , double tolerance ); 

	public native double[][] solve( int neq , double t0 , double tmax , int nSteps , double[] ic , double[] icp , double absTol , double relTol ); 

	public abstract int computeNextStep ( double t , double[] y , double[] yp   , double[] ypp );


	private int NEQ;
	public int getNEQ(){
		return NEQ;
	}

	/*public void setNEQ(int n){
		this.NEQ=n;
	}*/



}