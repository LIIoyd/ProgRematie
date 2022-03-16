import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
public interface ServiceDistributeur extends Remote {
    public void enregistrer(ServiceMatrice a) throws RemoteException,ServerNotActiveException;
    public double[][] calculerMatrice(double[][] m1,double[][] m2) throws RemoteException,ServerNotActiveException;
}
