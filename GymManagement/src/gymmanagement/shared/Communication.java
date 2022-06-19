/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymmanagement.shared;

import gymmanagement.model.Admin;
import gymmanagement.model.Trainer;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Yohannes
 */
public interface Communication extends Remote{
    public boolean AdminLogin(Admin admin) throws RemoteException;
    public boolean trainerLogin(Trainer trainer) throws RemoteException;
    public boolean addTrainer(Trainer trainer) throws RemoteException;
}
