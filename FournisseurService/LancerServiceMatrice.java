import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
public class LancerServiceMatrice {
    
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
		distrib.enregistrer((ServiceMatrice) UnicastRemoteObject.exportObject(new Matrice(), 0));
	}
}
