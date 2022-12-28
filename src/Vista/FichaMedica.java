/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Paciente;
import ModeloRecepcionista.CargarCombo;
import ModeloRecepcionista.Conexion;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RojeruSan
 */
public class FichaMedica extends javax.swing.JPanel {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    /**
     * Creates new form pnlHome
     */
    public FichaMedica() {
        initComponents();
        CargarPaciente();
        txtInfoImc.setVisible(false);
    }

    public void CargarPaciente() {
        CargarCombo cargarCombo = new CargarCombo();
        ArrayList<Paciente> listaPaciente = cargarCombo.getPaciente();

        for (int i = 0; i < listaPaciente.size(); i++) {
            comboRut.addItem(listaPaciente.get(i).getId());
        }
    }

    public void listar() {
        try {
            String id = comboRut.getSelectedItem().toString();
            String sql = "SELECT paciente.id,nombre,apellido_paterno,apellido_materno,telefono,direccion,prevision.prevision,sexo.sexo FROM `paciente` "
                    + "RIGHT JOIN prevision on paciente.Prevision_id = prevision.id RIGHT JOIN sexo on paciente.sexo_id = sexo.id where paciente.id = ?";
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                txtNombre.setText(rs.getString("nombre"));
                txtApellidoP.setText(rs.getString("apellido_paterno"));
                txtApellidoM.setText(rs.getString("apellido_materno"));
                txtApellidoM.setText(rs.getString("apellido_materno"));
                txtSexo.setText(rs.getString("sexo.sexo"));
                txtTelefono.setText(rs.getString("telefono"));
                txtDireccion.setText(rs.getString("direccion"));
                txtPrevision.setText(rs.getString("prevision.prevision"));

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar: " + e);
            Logger.getLogger(CargarCombo.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public float validaFloat(String number) {
        float result = 0; //Valor default.
        try {
            if (number != null) {
                result = Float.parseFloat(number);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "ERROR Numero: " + nfe);
            //*No es numerico!
        }
        return result;
    }

    public float IMC() {

        Float p = validaFloat(txtPeso.getText().trim());
        Float t = validaFloat(txtTalla.getText().trim());
        Float Imc = p / (t * t);
//        Agregar(Imc);
        String imc = Imc.toString();
        System.out.println(imc);
        txtImc.setText(imc);

        return Imc;
    }

    public void Imc() {
        Float p = validaFloat(txtPeso.getText().trim());
        Float t = validaFloat(txtTalla.getText().trim());
        Float Imc = p / (t * t);
        Agregar(Imc);
    }

    public void ImCDecil() {

        if (IMC() < 16.00) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Infrapeso: Delgadez Severa");
        } else if (IMC() <= 16.00 || IMC() <= 16.99) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Infrapeso: Delgadez moderada");
        } else if (IMC() <= 17.00 || IMC() <= 18.49) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Infrapeso: Delgadez aceptable");
        } else if (IMC() <= 18.50 || IMC() <= 24.99) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Peso Normal");
        } else if (IMC() <= 25.00 || IMC() <= 29.99) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Sobrepeso");
        } else if (IMC() <= 30.00 || IMC() <= 34.99) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Obeso: Tipo I");
        } else if (IMC() <= 35.00 || IMC() <= 40.00) {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("Obeso: Tipo III");
        } else {
            txtInfoImc.setVisible(true);
            txtInfoImc.setText("no existe clasificacion");
        }
    }

    public void Agregar(Float Imc) {
        String id = comboRut.getSelectedItem().toString();
        String habitos = txtHabitos.getText();
        String alergias = txtAlergias.getText();
        String cirugias = txtCirugias.getText();
        String hosp = txtHospitalizaciones.getText();
        String antecedentes = txtAntecedentes.getText();
        Float peso = Float.valueOf(txtPeso.getText());
        Float talla = Float.valueOf(txtPeso.getText());
        int cardiaca = Integer.parseInt(txtCardiaca.getText());
        int respiratoria = Integer.parseInt(txtRespiratoria.getText());
        int so2 = Integer.parseInt(txtso2.getText());
        int presion = Integer.parseInt(txtPresion.getText());
        String descp = txtDescp.getText();
        try {
            //||sexo.equals("")
            if (habitos.equals("") || alergias.equals("")
                    || cirugias.equals("") || hosp.equals("") || antecedentes.equals("") || peso.equals(0)
                    || talla.equals(0) || Imc.equals(0) || cardiaca == 0 || respiratoria == 0 || so2 == 0 || presion == 0 || descp.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar todos los Datos");

            } else {
                System.out.println(Imc);
                String sql = "insert into expediente(habitos,alergias,cirugias,hospitalizaciones,antecedentes_morbidos,peso,talla,imc,frecuencia_cardiaca,frecuencia_respiratoria,"
                        + "so2,presion_arterial,descripcion_dolor,paciente_id) values"
                        + "('" + habitos + "','" + alergias + "','" + cirugias + "','"
                        + hosp + "','" + antecedentes + "','" + peso + "','" + talla + "','" + Imc + "','" + cardiaca + "','" + respiratoria + "','" + so2 + "'"
                        + ",'" + presion + "','" + descp + "','" + id + "')";
                con = Conexion.getConexion();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Ficha Ingresada Con Exito");
                nuevo();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Insertar:  " + e);
            System.out.println(e);
        }

    }

    public void Agregar() {
    }

    public void nuevo() {
        comboRut.setSelectedIndex(0);
        txtApellidoM.setText("");
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtPrevision.setText("");
        txtPresion.setText("");
        txtSexo.setText("");
        txtHospitalizaciones.setText("");
        txtCirugias.setText("");
        txtCardiaca.setText("");
        txtRespiratoria.setText("");
        txtDescp.setText("");
        txtHabitos.setText("");
        txtAlergias.setText("");
        txtAntecedentes.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
        txtImc.setText("");
        txtTelefono.setText("");
        txtso2.setText("");
        txtInfoImc.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboRut = new javax.swing.JComboBox<>();
        txtPrevision = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtHabitos = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        txtCirugias = new javax.swing.JTextField();
        txtAntecedentes = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtHospitalizaciones = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtImc = new javax.swing.JTextField();
        txtCardiaca = new javax.swing.JTextField();
        txtPresion = new javax.swing.JTextField();
        txtRespiratoria = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtDescp = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtTalla = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtso2 = new javax.swing.JTextField();
        btnImc = new javax.swing.JButton();
        txtInfoImc = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel7.setText("Nombre");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel10.setText("Apellido Paterno");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel11.setText("Sexo");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel12.setText("Telefono");

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel16.setText("Apellido Materno");

        jLabel14.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel14.setText("Direccion");

        jLabel17.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel17.setText("Prevision");

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidoP.setEditable(false);
        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });

        txtApellidoM.setEditable(false);
        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });

        txtDireccion.setEditable(false);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtTelefono.setEditable(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel9.setText("Rut");

        comboRut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Seleccionado" }));
        comboRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRutActionPerformed(evt);
            }
        });

        txtPrevision.setEditable(false);
        txtPrevision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrevisionKeyTyped(evt);
            }
        });

        txtSexo.setEditable(false);
        txtSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSexoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtTelefono)
                            .addComponent(txtPrevision, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellidoM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtApellidoP)
                            .addComponent(txtSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboRut, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRut, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrevision, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("Crear Ficha Medica");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel8.setText("Alergias");

        txtHabitos.setDoubleBuffered(true);
        txtHabitos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHabitosKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel13.setText("Cirugias");

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel15.setText("Antecedente Morbidos");

        jLabel19.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel19.setText("Hospitalizaciones");

        txtAlergias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlergiasKeyTyped(evt);
            }
        });

        txtCirugias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCirugiasKeyTyped(evt);
            }
        });

        txtAntecedentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAntecedentesKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel22.setText("Habitos");

        txtHospitalizaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHospitalizacionesKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHabitos, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtAlergias)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAntecedentes, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtCirugias)
                            .addComponent(txtHospitalizaciones))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHabitos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCirugias, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHospitalizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        jLabel23.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel23.setText("Talla");

        txtPeso.setDoubleBuffered(true);
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel25.setText("Frecuencia Respiratoria");

        jLabel26.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel26.setText("so2");

        jLabel27.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel27.setText("Frecuencia Cardiaca");

        jLabel28.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel28.setText("Descripcion Dolor");

        txtImc.setEditable(false);
        txtImc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImcKeyTyped(evt);
            }
        });

        txtCardiaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCardiacaKeyTyped(evt);
            }
        });

        txtPresion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresionKeyTyped(evt);
            }
        });

        txtRespiratoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRespiratoriaKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel30.setText("Peso");

        txtDescp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescp.setDropMode(javax.swing.DropMode.INSERT);
        txtDescp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescpKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel31.setText("IMC");

        txtTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTallaKeyTyped(evt);
                txtNumeroFloat(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel32.setText("Presion Arterial");

        txtso2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtso2KeyTyped(evt);
            }
        });

        btnImc.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnImc.setText("Calcular");
        btnImc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnImc.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnImc.setVerifyInputWhenFocusTarget(false);
        btnImc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImcActionPerformed(evt);
            }
        });

        txtInfoImc.setText("mensaje imc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtso2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(txtRespiratoria)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtPresion)
                                    .addGap(44, 44, 44)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(txtTalla))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtImc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnImc))
                                    .addComponent(txtInfoImc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(txtDescp))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addComponent(txtCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInfoImc)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRespiratoria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtso2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPresion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Nuevo");
        btnLimpiar.setToolTipText("");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Formularioo");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void comboRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRutActionPerformed
        listar();
    }//GEN-LAST:event_comboRutActionPerformed

    private void txtAntecedentesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAntecedentesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAntecedentesKeyTyped

    private void txtCirugiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCirugiasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCirugiasKeyTyped

    private void txtAlergiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlergiasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlergiasKeyTyped

    private void txtHabitosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHabitosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHabitosKeyTyped

    private void txtHospitalizacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHospitalizacionesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHospitalizacionesKeyTyped

    private void txtDescpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescpKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescpKeyTyped

    private void txtRespiratoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRespiratoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespiratoriaKeyTyped

    private void txtPresionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresionKeyTyped

    private void txtCardiacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCardiacaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCardiacaKeyTyped

    private void txtImcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImcKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImcKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtTallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTallaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTallaKeyTyped

    private void txtso2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtso2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtso2KeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPrevisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrevisionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrevisionKeyTyped

    private void txtSexoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSexoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Agregar();
        nuevo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnImcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImcActionPerformed
        // TODO add your handling code here:
//        IMC();
        if (esNumFloat(txtPeso.getText().trim())) {
        }
        if (esNumFloat(txtTalla.getText().trim())) {
        }
        ImCDecil();

    }//GEN-LAST:event_btnImcActionPerformed

    private void txtNumeroFloat(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroFloat
        // TODO add your handling code here:        char caracter = evt.getKeyChar();
        char caracter = evt.getKeyChar();
        if ((caracter < '0' || caracter > '9') && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '.' || txtTalla.getText().contains(".")) && (caracter != '.' || txtPeso.getText().contains("."))) {
            evt.consume();

        }
    }//GEN-LAST:event_txtNumeroFloat

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public boolean esNumFloat(String cadena) {
        try {
            Float.valueOf(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnImc;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JComboBox<String> comboRut;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel title;
    public javax.swing.JTextField txtAlergias;
    public javax.swing.JTextField txtAntecedentes;
    public javax.swing.JTextField txtApellidoM;
    public javax.swing.JTextField txtApellidoP;
    public javax.swing.JTextField txtCardiaca;
    public javax.swing.JTextField txtCirugias;
    public javax.swing.JTextField txtDescp;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtHabitos;
    public javax.swing.JTextField txtHospitalizaciones;
    public javax.swing.JTextField txtImc;
    public javax.swing.JLabel txtInfoImc;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtPresion;
    public javax.swing.JTextField txtPrevision;
    public javax.swing.JTextField txtRespiratoria;
    public javax.swing.JTextField txtSexo;
    public javax.swing.JTextField txtTalla;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtso2;
    // End of variables declaration//GEN-END:variables
}
