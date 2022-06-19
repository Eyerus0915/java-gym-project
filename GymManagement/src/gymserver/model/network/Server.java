package gymserver.model.network;


import gymmanagement.model.Admin;
import gymmanagement.model.Trainer;
import gymmanagement.shared.Communication;
import gymserver.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server  implements Communication{
    
    public Server() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public boolean AdminLogin(Admin admin) throws RemoteException {
        return DatabaseConnection.getInstance().AdminLogin(admin);
    }

    @Override
    public boolean trainerLogin(Trainer trainer) throws RemoteException {
        return DatabaseConnection.getInstance().trainerLogin(trainer);
    }

    @Override
    public boolean addTrainer(Trainer trainer) throws RemoteException {
        // add the trainer by the database class
        return DatabaseConnection.getInstance().addTrainer(trainer);
    }

   
 
    
}
