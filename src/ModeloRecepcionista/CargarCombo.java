/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloRecepcionista;

import Entidades.Paciente;
import Entidades.Personal;
import Entidades.Prevision;
import Entidades.Sexo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author avile
 */
public class CargarCombo extends Conexion {

    Statement st;
    ResultSet rs;

    public ArrayList<Sexo> getSexos() {

        con = Conexion.getConexion();

        ArrayList<Sexo> listaSexo = new ArrayList<>();

        try {
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM sexo");

            while (rs.next()) {

                Sexo sexo = new Sexo();
                sexo.setId(rs.getInt("id"));
                sexo.setSexo(rs.getString("sexo"));
                listaSexo.add(sexo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSexo;

    }

    public ArrayList<Prevision> getPrevisions() {
        con = Conexion.getConexion();

        ArrayList<Prevision> listaPrevision = new ArrayList<>();

        try {
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM prevision");

            while (rs.next()) {
                Prevision prevision = new Prevision();
                prevision.setId(rs.getInt("id"));
                prevision.setPrevision(rs.getString("prevision"));
                listaPrevision.add(prevision);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPrevision;
    }

    public ArrayList<Paciente> getPaciente() {
        con = Conexion.getConexion();

        ArrayList<Paciente> listaPacientes = new ArrayList<>();

        try {
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM paciente");

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getString("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido_paterno(rs.getString("apellido_paterno"));
                paciente.setApellido_materno(rs.getString("apellido_materno"));
                listaPacientes.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPacientes;
    }
    
        public ArrayList<Personal> getPersonal() {
        con = Conexion.getConexion();

        ArrayList<Personal> listaPersonal = new ArrayList<>();

        try {
            st = con.createStatement();

            rs = st.executeQuery("SELECT personal.id,nombre,apellido_paterno,apellido_materno,rol_id,rol.nombre_tipo FROM `personal`"
                    + " INNER JOIN rol on personal.rol_id = rol.id; ");

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

}

//        String sql = "SELECT sexo FROM `sexo`";
//        try {
//            con = Conexion.getConexion();
//            PreparedStatement pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                comboSexo.addItem(rs.getString("sexo")); // aca es donde cargas el combobox con el registro de la BD
//            }
//
//            con.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
