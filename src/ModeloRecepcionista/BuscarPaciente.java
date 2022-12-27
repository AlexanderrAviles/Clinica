/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloRecepcionista;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author avile
 */
public class BuscarPaciente extends Conexion {

    private Component rootPane;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    public void buscar(String brut, String nombre, String rut, JTextField txtNombre, JTextField txtRut) {
        if (brut.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese Rut", "Error", 1);
        } else {

            try {
                con = getConexion();
                ps = con.prepareStatement("Select * from paciente where rut = ?");
                ps.setString(1, brut);
                rs = ps.executeQuery();

                if (rs.next()) {
                    txtNombre.setText(rs.getString("nombre") + " " + rs.getString("apellido_paterno") + " " + rs.getString("apellido_materno"));
                    txtRut.setText(rs.getString("rut"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No existe registro" + e);
            }

        }
    }

}
