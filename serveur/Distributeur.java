import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
public class Distributeur implements ServiceDistributeur{
    
    public ArrayList<ServiceMatrice> listeServiceDispo = new ArrayList<ServiceMatrice>();


    public void enregistrer(ServiceMatrice a){
        listeServiceDispo.add(a);
    }

    public double[][] calculerMatrice(double[][] m1,double[][] m2) throws RemoteException,ServerNotActiveException{
       return listeServiceDispo.get(0).calculerMatrice(m1, m2);
    }

}