package gymserver;


import gymserver.model.network.Server;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

/**
 *
 * @author tsion
 */
public class GymServer {


    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Server server = new Server();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Communication", server);
        System.out.println("SERVER RUNNING");
    }
    
}
