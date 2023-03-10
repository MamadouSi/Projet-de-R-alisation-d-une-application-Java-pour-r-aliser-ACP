package da.project.acp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

import da.project.acp.Vector;

public class Acp implements IAcp {
	private List<Vector> vectors = new ArrayList<>();

	public Acp(List<Vector> vectors) {
		this.vectors = vectors;

	}

	public void printData() {
		System.out.println(vectors);
	}

	@Override
	public void printComponents() {
		// TODO Auto-generated method stub
		// print new components in the console
		System.out.println("components------------");

	}

	//---------------------Lire le fichier txt
	public static ArrayList<Vector> loadData(File file) {
		// path="src/da/project/math_box/data.txt"
		//File file = new File(path);

		String[] tmpStrTab;
		ArrayList<Vector> vectors = new ArrayList<>();// each vector is a line
														// in the text file
		BufferedReader bfr = null;
		try {
			bfr = new BufferedReader(new FileReader(file));
			// -->File
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while (bfr.ready()) {
				String ligne = bfr.readLine();
				tmpStrTab = ligne.split(";");
				double values[] = new double[tmpStrTab.length];
				for (int i = 0; i < tmpStrTab.length; i++) {
					values[i] = Double.parseDouble(tmpStrTab[i]);
				}
				vectors.add(new Vector(values));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vectors;
	}
	
	
	//Ecrire fichier txt
	public static void writerData(double[][] A,String str) {
		File file = new File(str);

		try (BufferedWriter bfr = new BufferedWriter(new FileWriter(file))){
			for(int i=0;i< A.length;i++) {
				bfr.write(A[i][0]+"");
				for(int j=1;j< A[0].length;j++) {
					bfr.write(";");
					bfr.write(A[i][j]+"");
				}bfr.newLine();
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//----------------------------------------------------------
	public static void writerData1(double[] A,String str) {
		File file = new File(str);

		try (BufferedWriter bfr = new BufferedWriter(new FileWriter(file))){
			
				bfr.write(A[0]+"");
				for(int j=1;j< A.length;j++) {
					bfr.write(";");
					bfr.write(A[j]+"");
				}
				
				
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//----------------------------------------------------------------Vecteur en matrice 
	public static double[][] vector_to_matrice (List<Vector> vectors) {
		double[] a=vectors.get(0).getCoordinates();
		double A[][] =new double[vectors.size()][a.length];
		int i;
		int j;
		for(i=0;i<vectors.size();i++) {
			a=vectors.get(i).getCoordinates();
			for(j=0;j<a.length;j++) {
				A[i][j]=a[j];
			}
		}
		
		
		return A;
		
	}
	
//-------------------------------------------------Afficher Matrice 
	public static void afficher_matrix(double[][] A) {
		int i,j;
		DecimalFormat df = new DecimalFormat("0.000"); // 

		for(i=0;i<A.length;i++) {
			System.out.print("[");
			for(j=0;j<A[0].length;j++) {
				System.out.print(df.format(A[i][j])+"\t");
			}
			System.out.print("]\n");
			
		}
		System.out.println("----------------------------------------\n");
	}
//-------------------------------------------------Crentrer la matrice 
	public static double[][] centerMatrix(double[][] A) {
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
//-------------------------------------------------Reduire la matrice 
	public static double[][] reduire (double[][] M){
				int i,j;
				double[] ecart=new double[M[0].length];
				for(i=0;i<M.length;i++) {
					for(j=0;j<M[0].length;j++) {
						ecart[j]=ecart[j]+ Math.pow(M[i][j], 2);
					}
					
				}
				for(j=0;j<M[0].length;j++) {
					ecart[j]=Math.sqrt(ecart[j]/M.length);
				}
				double[][] A = new double[M.length][M[0].length];
				for(i=0;i<M.length;i++) {
					for(j=0;j<M[0].length;j++) {
						A[i][j]=(M[i][j]/ecart[j]);
					}
					
				}
				
				return A;
			}

//------------calcule matrice covariance------------------
	public static double[][] cov(double[][] A){
				int i,j,k,l,m,q;
				int n=A.length;
				double prod;
				double[][] B=new double[A.length][2];
				
				double[][] cov=new double[A[0].length][A[0].length];
				for(i=0;i<cov.length;i++) {
					for(j=0;j<cov.length;j++) {
						if(i==j) {
							cov[i][j]=0;
							for(k=0;k<A.length;k++) {
								cov[i][j]+= Math.pow(A[k][j],2);		
							}cov[i][j]/=(n-1);
							
							
						}else {
							for(q=0;q<A.length;q++) {
								B[q][0]=A[q][i];
								B[q][1]=A[q][j];
							}
							
							
							
							cov[i][j]=0;
							for(l=0;l<A.length;l++) {
								prod=1;
								for(m=0;m<B[0].length;m++) {
									prod*=B[l][m];
									
								}cov[i][j]+=prod;
									
							}cov[i][j]/=(n-1);
							
							
						}
					}
				}
				
				return cov;
				
			}
//------------calcule matrice correlation------------------
	public static double[][] cor(double[][] A){
		int i,j,k,l,m,q;
		int n=A.length;
		double prod;
		double[][] B=new double[A.length][2];
		
		double[][] cov=new double[A[0].length][A[0].length];
		for(i=0;i<cov.length;i++) {
			for(j=0;j<cov.length;j++) {
				if(i==j) {
					cov[i][j]=0;
					for(k=0;k<A.length;k++) {
						cov[i][j]+= Math.pow(A[k][j],2);		
					}cov[i][j]/=(n);
					
					
				}else {
					for(q=0;q<A.length;q++) {
						B[q][0]=A[q][i];
						B[q][1]=A[q][j];
					}
					
					
					
					cov[i][j]=0;
					for(l=0;l<A.length;l++) {
						prod=1;
						for(m=0;m<B[0].length;m++) {
							prod*=B[l][m];
							
						}cov[i][j]+=prod;
							
					}cov[i][j]/=(n);
					
					
				}
			}
		}
		
		return cov;
		
	}
										
//---------------------CalculValeurpropre-------------------------
	public static double[] eign_value(double[][] A) {
		
				
				RealMatrix mat=new Array2DRowRealMatrix(A);
				EigenDecomposition a=new EigenDecomposition(mat);
				double[] rep=new double[2];
				rep=a.getRealEigenvalues();
				
		        return rep;
			}
	
	//------------------------------Pourcentage valeur propre 
	public static void pourcentage_eign_value(double[] eg) {
		int i;
		double sum=0;
		
		DecimalFormat df1 = new DecimalFormat("0.00");
		for(i=0;i<eg.length;i++) {
			sum+=eg[i];
		}
		System.out.println("------Les valeurs propres sont :---------");
		for(i=0;i<eg.length;i++) {
			System.out.print(df1.format((eg[i]/sum)*100)+"%\t");
		}
		
		System.out.println("\n----------------------------------------\n");
	}	
	
	
	public static double[] prt_eign_value(double[] eg) {
		
		
		int i;
		double[] rep=new double[eg.length];
		double sum=0;
		DecimalFormat df1 = new DecimalFormat("0.00");
		
		for(i=0;i<eg.length;i++) {
			sum+=eg[i];
		}
		
		for(i=0;i<eg.length;i++) {
			rep[i]=(eg[i]/sum)*100;
		}
		
        return rep;
	}
			
//-------------------------Afficher Valeur propre -----------------------
	public static void afficher_eign_value(double[] eg) {
				int i;
				DecimalFormat df = new DecimalFormat("0.0000");
				System.out.println("------Les valeurs propres sont :---------");
				for(i=0;i<eg.length;i++) {
					System.out.print(df.format(eg[i])+"\t");
				}
				
				System.out.println("\n----------------------------------------\n");
			}		
//---------------------CalculVecteurspropre-------------------------
	public static double[][] eign_vecteur(double[][] A) {
		RealMatrix mat = new Array2DRowRealMatrix(A);
		EigenDecomposition a=new EigenDecomposition(mat);
		double[][] eigenvects = new double[A.length][A.length];
		
		for (int i = 0; i < A.length; i++) {
	
			eigenvects[i] =a.getEigenvector(i).toArray();
		}
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
					eigenvects[i][j]=-eigenvects[i][j];
			}
			
			
		}
		
  
		return eigenvects;
	}
//------------------------------Projection ---------------------------
	public static double[][] projection(double[][] A,double[][] B) {
		double[][] matrix_trans=transpose(A);
		
	    double[][] proj=prodMat(B,matrix_trans);
	    return transpose(proj);
		
	}
	
	
	
	
	

//--------------TransposerUneMatrice----------------
			public static double[][] transpose(double[][] A){
				double[][] B=new double [A[0].length][A.length];
				int i,j;
				for(i=0;i<A.length;i++) {
					for(j=0;j<A[0].length;j++) {
						B[j][i]=A[i][j];
					}
				}
				
				
				
				return B;
				
			}
	
//------------ProduitMatricielle-----------------
			public static double[][] prodMat(double[][] A,double[][] B){
				double[][] prod=new double [A.length][B[0].length];
				int i,j,k;
				for(i=0;i<A.length;i++) {
					for(j=0;j<B[0].length;j++) {
						prod[i][j]=0;
						for(k=0;k<A.length;k++) {
							prod[i][j]+=(A[i][k]*B[k][j]);
						}
					}
				}
				return prod;
				
			}
			
			//------------ProduitMatricielle suivant n-----------------
			public static double[][] projection_n(double[][] A,int n){
				double[][] prod=new double [A.length][n];
				int i,j;
				for(i=0;i<A.length;i++) {
					for(j=0;j<n;j++) {
						prod[i][j]=A[i][j];
					}
				}
				return prod;
				
			}
	
	
	@Override
	public ArrayList<Vector> getComponents(double information_percentage) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void drawData() {
		// TODO Auto-generated method stub
		// use javaFX to draw original data
	}
	@Override
	public void drawComponents() {
		// TODO Auto-generated method stub
		// use javaFX to draw new components
	}

	@Override
	public void printEigenComponents() {
		// TODO Auto-generated method stub
		System.out.println("eigen values------------");

		System.out.println("eigen vectors------------");

		
	}

	@Override
	public void printCorrelationMatrix() {
		// TODO Auto-generated method stub
		System.out.println("correlation matrix------------");

		
	}
}
