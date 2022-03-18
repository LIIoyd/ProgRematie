import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
public interface ServiceMatrice extends Remote {
    public double calculerTab(double[] m1,double[] m2) throws RemoteException,ServerNotActiveException;
}
