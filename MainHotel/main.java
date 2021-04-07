/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainHotel;

import ExceptionHotel.PelangganException;
import ReserveHotel.view.Login_Form;
import ReserveHotel.view.MainView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hopeless
 */
public class main {
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login_Form login = new Login_Form();
                login.setVisible(true);
            }
        });
        
    
        
    
    

    
}
}
