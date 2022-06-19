
package gymmanagement.network;

import gymmanagement.model.Admin;
import gymmanagement.model.Trainer;
import gymmanagement.shared.Communication;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    
    Communication serverCom;
    private static Client instance;
    
    public static Client getInstance(){
        if(instance == null)
            try {
                return new Client();
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
    
    
    public Client() throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverCom = (Communication) registry.lookup("Communication");
    }
    
    
    public boolean adminLogin(Admin admin){
        try {
            return serverCom.AdminLogin(admin);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean trainerLogin(Trainer trainer){
        try {
            return serverCom.trainerLogin(trainer);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

       return false; 
    }
    public boolean addTrainer(Trainer trainer){
        try {
            return serverCom.trainerLogin(trainer);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

       return false; 
    }
    
}
