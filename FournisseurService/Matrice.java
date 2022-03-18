import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
public class Matrice implements ServiceMatrice{

	
	public  double calculerTab(double[] tab1,double[] tab2){
		double res = 0;
		System.out.println("Realisation du calcul avec les tableaux");
		System.out.println("Tableau 1:");
		afficherTab(tab1);
		System.out.println("Tableau 2:");
		afficherTab(tab2);
		for(int i=0; i<tab1.length; i++){
			res += tab1[i] * tab2[i];    
		}
		System.out.println("Resultat obtenue " +res);
		return res;
	}
	
	
	public static void afficherTab(double tab[]){
		System.out.println("");
		for(int i=0; i<tab.length;i++){
				System.out.print(tab[i]+ "  ");
		}
		System.out.println("");
    }
}
