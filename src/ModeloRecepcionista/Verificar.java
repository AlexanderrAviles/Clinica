/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloRecepcionista;

import Vista.MenuAdministrador;
import Vista.MenuKinesiologo;
import Vista.MenuRecepcionista;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import principal.FormLogin;

/**
 *
 * @author avile
 */
public class Verificar extends Conexion {

    private Component rootPane;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public void verificarinicio(String uname, String pword, String option) {
        if (uname.equals("") || pword.equals("") || option.equals("Seleccione tipo de usuario")) {
            JOptionPane.showMessageDialog(rootPane, "Algunos campos estan vacios", "Error", 1);
        } else {
            try {
                con = getConexion();
                ps = con.prepareStatement("select * from personal where usuario = ? and password = ?");
                ps.setString(1, uname);
                ps.setString(2, pword);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String sl = rs.getString("Rol_id");
                    String nom = rs.getString("nombre");
                    String ape = rs.getString("apellido_paterno");
                    if (option.equalsIgnoreCase("Administrador") && sl.equalsIgnoreCase("1")) {
                        MenuAdministrador ad = new MenuAdministrador();
                        ad.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bienvenido(a) " + nom + " " + ape);
                    }
                    if (option.equalsIgnoreCase("Kinesiologo") && sl.equalsIgnoreCase("1")) {
                        MenuKinesiologo kn = new MenuKinesiologo();
                        kn.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bienvenido(a) " + nom + " " + ape);
                    }
                    if (option.equalsIgnoreCase("Recepcionista") && sl.equalsIgnoreCase("2")) {
                        MenuRecepcionista rc = new MenuRecepcionista();
                        rc.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bienvenido(a) " + nom + " " + ape);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El usuario y/o contraseña es incorrecto", "Login Error", 1);
                }

            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
    }

}
