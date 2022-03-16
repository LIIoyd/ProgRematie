import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
public class ProduitMatrice implements ServiceMatrice{

	public static void main(String []args) throws RemoteException, NotBoundException,ServerNotActiveException{
		String serveur="localhost";    // par défaut le serveur est sur la même machine
        int port=1099;                     // le port de la rmiregistry par défaut 
        if(args.length >0)
            serveur=args[0];
        if(args.length > 1)
            port=Integer.parseInt(args[1]);
            
        Registry reg = LocateRegistry.getRegistry(serveur,port);
        String[] list = reg.list();
        System.out.println("Liste des Service :");
        for(int i=0 ; i<list.length;i++)System.out.println("* "+list[i]); 
        ServiceDistributeur distrib = (ServiceDistributeur) reg.lookup("distributeur");
		distrib.enregistrer((ServiceMatrice) UnicastRemoteObject.exportObject(new ProduitMatrice(), 0));
	}
	
	public  double[][] calculerMatrice(double[][] m1,double[][] m2){
		double[][] res = new double[m1.length][m2[0].length ];
		for(int i=0; i<m1.length;i++){
			for(int j=0; j<m2[0].length;j++){
				res[i][j]= 0;
			}
		}
		for(int i=0; i<m1.length; i++){
			for(int j=0; j<m2[0].length; j++){ 
				for(int k=0; k<m1[i].length ;k++)    
				{ 
					res[i][j] += m1[i][k] * m2[k][j];    
				}
			}
			
		} 
		return res;
	}
	
	

}

/*
public static void main(String args[]){
		//Nombre de ligne de la matrice1
		int NombreLigne1 = Integer.parseInt(args[0]);
		//Nombre de colonne de la matrice1
		int NombreColonne1 = Integer.parseInt(args[1]);
		//Nombre de ligne de la matrice2
		int NombreLigne2 = Integer.parseInt(args[2]);
		//Nombre de colonne de la matrice2
		int NombreColonne2 = Integer.parseInt(args[3]);



		double Matrice1[][] = new double[NombreLigne1][NombreColonne1 ];
		double Matrice2[][] = new double[NombreLigne2][NombreColonne2 ];


		//initialisation des matrices
		for(int i=0; i<NombreLigne1;i++){
			for(int j=0; j<NombreColonne1;j++){
				Matrice1[i][j]= 0;
			}
		}
		for(int i=0; i<NombreLigne2;i++){
			for(int j=0; j<NombreColonne2;j++){
				Matrice2[i][j]=0;
			}
		}

		
		Scanner sc = new Scanner(System.in);

		System.out.println("Matrice 1");
		ProduitMatrice.AfficherMatrice(Matrice1);
		//Choix des valeurs de la premiere matrice
		for(int i= 0; i<NombreLigne1;i++){
			for(int j=0 ; j<NombreColonne1 ;j++){
				System.out.println("rentre la valeur a la position " + j + " ; " + i);
				Matrice1[i][j] = sc.nextDouble() ;
				ProduitMatrice.AfficherMatrice(Matrice1);
			}
		}

		System.out.println("Matrice 2");
		ProduitMatrice.AfficherMatrice(Matrice2);
		//Choix des valeurs de la premiere matrice

		for(int i= 0; i<NombreLigne2;i++){
			for(int j=0 ; j<NombreColonne2;j++){
				System.out.println("rentre la valeur a la position " + j + " ; " + i);
				Matrice2[i][j] = sc.nextDouble() ;
				ProduitMatrice.AfficherMatrice(Matrice2);
			}
		}

		sc.close();

		//Créer une matrice pour stocker la multiplication
		//Possede autant de ligne que la matrice1 et autant de colone que la matrice2		
		double[][] res = calculerMatrice(Matrice1,Matrice2);
		ProduitMatrice.AfficherMatrice(res);
		System.out.println("Resultat");
		//multiplication
	 
	
	}

	public static void AfficherMatrice(double Matrice[][]){
		for(int i=0; i<Matrice.length;i++){
			for(int j=0; j<Matrice[0].length;j++){
				System.out.print(Matrice[i][j] + " ");
			}
			System.out.println();
		}
	}*/