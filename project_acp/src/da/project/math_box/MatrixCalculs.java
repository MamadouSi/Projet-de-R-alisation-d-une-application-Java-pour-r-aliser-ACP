package da.project.math_box;

public interface MatrixCalculs {
public  double[][] initializeMatrix(int n,int m);
public  double[][] initializeMatrix(double M[][]);
public  double[][] centerMatrix(double M[][],int dim);
public  double[][] center_reduceMatrix(double M[][],int dim);
public  double[][] getCovarianceMatrix(double M[][]);
public  double[][] getCorrelationMatrix(double M[][]);
double[][] centerMatrix(double[][] A);



}
