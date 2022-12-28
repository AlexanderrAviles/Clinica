/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloRecepcionista;

import java.awt.Component;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author avile
 */
public class BuscarFichaPaciente extends Conexion {

    private Component rootPane;
    PreparedStatement ps;
    ResultSet rs;

    public void buscar(String brut, TextField txtNombre, TextField txtId, TextField txtApellidoP,
            TextField txtRut, TextField txtTelefono, TextField txtApellidoM, TextField txtSexo, TextField txtPrevision, TextField txtDireccion,
            TextField txtFechaNacimiento, TextField txtExamenes, TextField txtDiagnostico, TextField txtMedicamentos, TextField txtIndicacion) {
        if (brut.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese Rut", "Error", 1);
        } else {
            try {
                con = Conexion.getConexion();
                ps = con.prepareStatement("SELECT * FROM paciente WHERE id=?");
                ps.setString(1, brut);
                rs = ps.executeQuery();
                if (rs.next()) {
                    txtId.setText((rs.getString("id")));
                    txtNombre.setText(rs.getString("nombre"));
                    txtApellidoP.setText(rs.getString("apellido_paterno"));
                    txtApellidoM.setText(rs.getString("apellido_materno"));
                    txtSexo.setText(rs.getString("sexo"));
                    txtTelefono.setText(rs.getString("telefono"));
                    txtDireccion.setText(rs.getString("direccion"));
                    txtPrevision.setText(rs.getString("prevision"));

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
