/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloRecepcionista;

import java.util.ArrayList;
import Entidades.Personal;
import static ModeloRecepcionista.Conexion.con;
import static ModeloRecepcionista.Conexion.getConexion;
import com.mysql.fabric.xmlrpc.base.Params;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author avile
 */
public class CargarSesion {

    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    private Component rootPane;
    private JLabel txtVersion;

    public ArrayList<Personal> getPersonalSesion() {
        con = Conexion.getConexion();

        ArrayList<Personal> listaPersonal = new ArrayList<>();

        try {
            st = con.createStatement();

            rs = st.executeQuery("SELECT personal.id,nombre,apellido_paterno,apellido_materno, rol_id,rol.nombre_tipo "
                    + "FROM `personal` inner join rol on rol_id = rol.id where personal.id = '?'; ");

            while (rs.next()) {
                Personal personal = new Personal();
                personal.setId(rs.getString("id"));
                personal.setNombre(rs.getString("nombre"));
                personal.setApellido_paterno(rs.getString("apellido_paterno"));
                personal.setApellido_materno(rs.getString("apellido_materno"));
                personal.setRol_id(rs.getInt("rol_id"));
                personal.setNombre_tipo(rs.getString("rol.nombre_tipo"));
                listaPersonal.add(personal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPersonal;
    }

//    public void verSesion(JLabel txtSesion) {;
//        try {
//            con = getConexion();
//            System.out.println("HOOLIS");
//            ps = con.prepareStatement("SELECT personal.id,nombre,apellido_paterno,apellido_materno, rol_id,rol.nombre_tipo "
//                    + "FROM `personal` inner join rol on rol_id = rol.id where personal.id = ?; ");
//            System.out.println("Hello ");
//            ps.setString(1, );
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                txtSesion.setText(rs.getString("personal.id") + " " + rs.getString("nombre") + " " + rs.getString("apellido_paterno") + " " + rs.getString("apellido_materno"));
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "No existe registro" + e);
//            System.out.println(e);
//        }
//
//    }
//
//    public String obtenerRut(String rut) {
//        String rutt = rut;
////        System.out.println(rutt);
//        return rut;
//    }
//
//    public String verSesion(String rut) {
//        return rut;
//    }

}
