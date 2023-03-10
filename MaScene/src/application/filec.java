package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Vector;

public class filec {
	
	List<Vector> vectors = new ArrayList<>();
	//---------------------Lire le fichier txt
		public static ArrayList<Vector> loadData(String path) {
			// path="src/da/project/math_box/data.txt"
			File file = new File(path);

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
		
		
		
		
		
		
		public static double[] vector_to_vecteur (List<Vector> vectors) {
			double[] a=vectors.get(0).getCoordinates();
			
			double B[] =new double[a.length];
			
			int j;
		
				a=vectors.get(0).getCoordinates();
				for(j=0;j<a.length;j++) {
					
					B[j]=a[j];
					
				}
			
			
			
			return B;
			
		}
		
		
		
}
