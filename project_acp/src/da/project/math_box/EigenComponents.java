package da.project.math_box;

import java.util.ArrayList;

public class EigenComponents {
	private EigenVector eigen_vectors[]; // array of eigen vectors
	/*
	 * note that:
	 * 1. an eigenVector contains an eigen value and the corresponding vector (eigne)
	 * 2. use the MatrixCalculsImpl to perform matrix operations 
	 * */
	private double[][] correlation_matrix;
	private double[][] matrix;

	/*
	 * from a matrix, 1.calculate the correlation matrix 2.calculate eigen
	 * values and eigen vectors 4.sort the eigen vectors 5.normalize the fixed
	 * eigen vectors 6.calculate components
	 */
	public EigenComponents(double[][] matrix) {
		// to do
		// initialization
		// calculate the correlation matrix

	}

	public EigenComponents(ArrayList<Vector> data) {
		/*
		 * to do
		 * initialization
		 * from an arrayList of vectors (data), 
		 * initialize matrix
		 */
	}

	private void calculateEigenValues() {
		// to do
		// calculate the eigen values
	}

	private void calculateEigenVectors() {
		// to do
		// calculate the eigen vectors
	}
private void sortEigenComponents(){
	// to do
	// sort the eigen components in ascending order

}
	private void normalizeEigenVectors() {
		// to do
		// calculate the eigen vectors
	}

	private EigenVector[] getEigenComponents() {
		// to do
		// calculate the eigen values
		// calculate the eigen vectors
		// return the ascending sorted normalized eigen vectors
		return null;
	}

}
