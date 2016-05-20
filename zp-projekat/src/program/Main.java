/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import crypto.CertManager;
import crypto.CertManagerImpl;
import gui.MainWindow;

/**
 *
 * @author Mita
 */
public class Main {
     public static void main(String argv[]) {
        CertManager manager = new CertManagerImpl();
        MainWindow mainWindow = new MainWindow(manager);
        mainWindow.setVisible(true);
       
        
    }
}
