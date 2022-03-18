import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerService {
    public static void main(String[]args) throws RemoteException {
        int port = 1099;
        if(args.length > 0)
            port=Integer.parseInt(args[1]); 
        Registry reg = LocateRegistry.createRegistry(port);
        Distributeur distrib = new Distributeur();
        ServiceDistributeur rd= (ServiceDistributeur) UnicastRemoteObject.exportObject(distrib, 0);
        reg.rebind("distributeur",rd);
    }
}


