package da.project.math_box;

public class MatrixCalculsImpl implements MatrixCalculs {

	
	

	@Override
	public double[][] centerMatrix(double[][] A) {
		double[] moyennes = new double[A[0].length];
		int i,j;
		double[][] M = new double[A.length][A[0].length];
		
		for(i=0;i<A.length;i++) {
			for(j=0;j<A[0].length;j++) {
				moyennes[j]=moyennes[j]+ A[i][j];
			}
			
		}
		for(j=0;j<A[0].length;j++) {
			moyennes[j]=moyennes[j]/A.length;
		}
		
		
		for(i=0;i<A.length;i++) {
			for(j=0;j<A[0].length;j++) {
				M[i][j]=(A[i][j]-moyennes[j]);
			}
			
		}
		

		return M;
		
		
	}
	

	

	@Override
	public double[][] getCovarianceMatrix(double[][] M) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[][] getCorrelationMatrix(double[][] M) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public double[][] initializeMatrix(int n, int m) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public double[][] initializeMatrix(double[][] M) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public double[][] centerMatrix(double[][] M, int dim) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public double[][] center_reduceMatrix(double[][] M, int dim) {
		// TODO Auto-generated method stub
		return null;
	}

}
