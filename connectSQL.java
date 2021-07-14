
package conexionBDL;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Sanchez
 */
public class connectSQL {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;

    public void ConectarBasedeDatos() {
        try {
            final String Controlador = "com.mysql.cj.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://localhost:3306/login";
            conexion = DriverManager.getConnection(url_bd, "root", "pass123");
            sentencia = conexion.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   public void DesconectarBasedeDatos() {
        try {
            if (conexion != null) {
                if (sentencia != null) {
                    sentencia.close();
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return conexion;
    }
}

    

