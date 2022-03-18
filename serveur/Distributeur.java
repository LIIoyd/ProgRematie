import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.*;
import java.rmi.server.RemoteServer;

public class Distributeur implements ServiceDistributeur{
    
    public ArrayList<ServiceMatrice> listeServiceDispo = new ArrayList<ServiceMatrice>();


    public void enregistrer(ServiceMatrice a){
        String host = "";
        try{
            host = RemoteServer.getClientHost(); // Permet de récuperer l'ip du noeud qui s'enregistre
        }catch(ServerNotActiveException e) { }
        System.out.println("Nouveau noeud : "+host); //Affiche l'ip
        listeServiceDispo.add(a);
    }
    
    public double[][] calculerMatrice(double[][] m1,double[][] m2) throws RemoteException,ServerNotActiveException{
       double[][] res = new double [m1.length][m2[0].length];
       double[] tab1 = new double[m1[0].length];
       double[] tab2 = new double[m2.length];
       int i=0; //indice correspondant à la ligne de la 1ere Matrice;
       int j=0; //indice correspondant à la colonne de la 2ème Matrice
       int service = 0; //inddice correspondant au service
       while(i<m1[0].length){
           j=0;
            for(int k = 0; k < tab1.length; k++){
                tab1[k] = m1[i][k];
            }
           while(j<m2.length){
                for(int t = 0; t < tab1.length; t++){
                    tab2[t] = m2[t][j];
                }
                try {
                   res[i][j] = listeServiceDispo.get(service).calculerTab(tab1,tab2);
                   System.out.println("resultat du " + " calcul ");
                   AfficherMatrice(res);
                } catch (RemoteException e) {
                    System.out.println("Un noeud s'est retiré"); //On avertit qu'un noeud s'est retirer
                    listeServiceDispo.remove(listeServiceDispo.get(service)); //On l'enlève de la liste
                    j--; //On réduit pour passer a la  colonne précédente
                    service--;// on réduit pour passer au service précédent

                }
                j++; //On avance d'une colonne
                service++; //on avance d'un service
                if(service >= listeServiceDispo.size()){ //Vérification pour ne pas dépasser
                    service = 0;
                }
           }
           i++;
       }
       return res;
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


