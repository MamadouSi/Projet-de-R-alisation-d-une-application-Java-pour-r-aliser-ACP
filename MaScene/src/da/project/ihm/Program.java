package da.project.ihm;

import java.io.File;
import java.util.List;

import da.project.acp.Acp;
import da.project.acp.Vector;

public class Program {
public static void main(File str) {
	List<Vector> vectors=Acp.loadData(str);
	System.out.println("---Original data --------------------");
	double[][] matrice=Acp.vector_to_matrice(vectors);
	Acp.afficher_matrix(matrice);
	Acp.writerData(matrice,"C:\\Users\\mamadou\\eclispe\\MaScene\\OriginalData.txt");
	
	
	//-----------Matrice Centrer-----------------------------
	System.out.println("---Centered data --------------------");
	double[][] matrice_centrer=Acp.centerMatrix(matrice);
	Acp.afficher_matrix(matrice_centrer);
	
	
	//-----------Matrice Centrer Reduite-----------------------------
	System.out.println("---Centered Reduite data --------------------");
	double[][] matrice_cr=Acp.reduire(matrice_centrer);
	Acp.afficher_matrix(matrice_cr);
	
	//-----------Matrice Covariance-----------------------------
	System.out.println("---Variance Covariance Matrix --------------------");
	double[][] matrice_covariance=Acp.cov(matrice_centrer);
	
	Acp.afficher_matrix(matrice_covariance);
	
	//-----------Matrice Correlation-----------------------------
		System.out.println("---Correlation Matrix --------------------");
		double[][] matrice_correlation=Acp.cor(matrice_cr);
		Acp.afficher_matrix(matrice_correlation);
		
	//----------------------------------ValeursPropres
	    double[] valeur_propre=Acp.eign_value(matrice_covariance);
	    Acp.afficher_eign_value(valeur_propre);
	    Acp.pourcentage_eign_value(valeur_propre);
	    double[] prt_valeur_propre=Acp.prt_eign_value(valeur_propre);
	    Acp.writerData1(prt_valeur_propre,"C:\\Users\\mamadou\\eclispe\\MaScene\\PourcentageAxe.txt");
	
	    
	  //---------------------------------------VecteursPropres
	    double[][] vecteur_propre=Acp.eign_vecteur(matrice_covariance);
	    System.out.println("---------Affichage vecteur propre -----------");
	    Acp.afficher_matrix(vecteur_propre);
	   //----------------------------------ChoixComposantPrincippale 
	    
	    
	    
	    //--------------------------------------Projection
	    
	    System.out.println("--- Projection des individues ---");
	    double[][] project=Acp.projection(matrice_centrer,vecteur_propre); 
	    int n=2;
	    double[][] project_n=Acp.projection_n(project,n);
	    Acp.afficher_matrix(project_n);
	    Acp.writerData(project_n,"C:\\Users\\mamadou\\eclispe\\MaScene\\ReductedData.txt");
	
	
}
}
