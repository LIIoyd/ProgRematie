import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;
public class Principale {
    public static void main(String []args) throws RemoteException, NotBoundException,ServerNotActiveException{
        String serveur="localhost";    // par défaut le serveur est sur la même machine
        int port=1099;                     // le port de la rmiregistry par défaut 
        if(args.length >0)
            serveur=args[0];
        if(args.length > 1)
            port=Integer.parseInt(args[1]);
            
		Registry reg = null;	
		try {
			 reg = LocateRegistry.getRegistry(serveur,port);
		} catch (RemoteException e) {
			System.out.println("Aucun registre trouvé");
		}

        String[] list = reg.list();

        System.out.println("Liste des Service :");

        for(int i=0 ; i<list.length;i++)System.out.println("* "+list[i]); 

		ServiceDistributeur produitMatrice = null;
		try {
             produitMatrice = (ServiceDistributeur) reg.lookup("distributeur");
        } catch (NotBoundException e) {
            System.out.println("Le nom du service est éronné");
        } catch (RemoteException e){
			System.out.println("La référence du service n'as pas pu etre cree");
		}
		


        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre de ligne de la matrice 1:");
        //Nombre de ligne de la matrice1
		int NombreLigne1 =  sc.nextInt();

        System.out.println("Nombre de colonne de la matrice 1:");
		//Nombre de colonne de la matrice1
		int NombreColonne1 = sc.nextInt();

        System.out.println("Nombre de ligne de la matrice 2:");
		//Nombre de ligne de la matrice2
		int NombreLigne2 =sc.nextInt();

        System.out.println("Nombre de colonne de la matrice 2:");
		//Nombre de colonne de la matrice2
		int NombreColonne2 = sc.nextInt();

        if(NombreColonne1 != NombreLigne2){
            throw new Error("Multiplication de la matrice impossible car le nombre de ligne de la matrice 1 et differents du nombre de colonne de la matrice 2");
        }

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

		
		

		System.out.println("Matrice 1");
		AfficherMatrice(Matrice1);
		//Choix des valeurs de la premiere matrice
		for(int i= 0; i<NombreLigne1;i++){
			for(int j=0 ; j<NombreColonne1 ;j++){
				System.out.println("rentre la valeur a la position " + (j+1) + " ; " + (i+1));
				Matrice1[i][j] = sc.nextDouble() ;
				AfficherMatrice(Matrice1);
			}
		}

		System.out.println("Matrice 2");
		AfficherMatrice(Matrice2);
		//Choix des valeurs de la premiere matrice

		for(int i= 0; i<NombreLigne2;i++){
			for(int j=0 ; j<NombreColonne2;j++){
				System.out.println("rentre la valeur a la position " + (j+1) + " ; " + (i+1));
				Matrice2[i][j] = sc.nextDouble() ;
				AfficherMatrice(Matrice2);
			}
		}

		sc.close();

		//appelle la méthode calculerMatrice qui renvoit le produit de 2 matrice	
		double[][] res = produitMatrice.calculerMatrice(Matrice1,Matrice2);
		AfficherMatrice(res);
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
    }
	
}
