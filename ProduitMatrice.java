import java.util.Scanner;
public class ProduitMatrice{
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
				System.out.println("rentre la valeur a la position " + i + " ; " + j);
				Matrice1[i][j] = sc.nextDouble() ;
				ProduitMatrice.AfficherMatrice(Matrice1);
			}
		}

		System.out.println("Matrice 2");
		ProduitMatrice.AfficherMatrice(Matrice2);
		//Choix des valeurs de la premiere matrice

		for(int i= 0; i<NombreLigne2;i++){
			for(int j=0 ; j<NombreColonne2;j++){
				System.out.println("rentre la valeur a la position " + i + " ; " + j);
				Matrice2[i][j] = sc.nextDouble() ;
				ProduitMatrice.AfficherMatrice(Matrice2);
			}
		}

		sc.close();

		//Créer une matrice pour stocker la multiplication
		//Possede autant de ligne que la matrice1 et autant de colone que la matrice2		
		double C[][] = new double[NombreLigne1][NombreColonne2];  

		System.out.println("Resultat");
		//multiplication
		for(int i=0; i<NombreLigne1; i++){
			for(int j=0; j<NombreColonne2; j++){ 
				C[i][j] = 0;    
				for(int k=0; k<NombreColonne1 ;k++)    
				{ 
					C[i][j] += Matrice1[i][k] * Matrice2[k][j];    
				}
				System.out.print(C[i][j]+" "); 
			}
			System.out.println();
		}  
	
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

