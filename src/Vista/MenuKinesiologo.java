/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Vista.CambiaPanel;

/**
 *
 * @author RojeruSan
 */
public class MenuKinesiologo extends javax.swing.JFrame {

    int x, y;

    /**
     * Creates new form Principal
     */

    public MenuKinesiologo() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        this.btn1.setSelected(true);

        new CambiaPanel(pnlPrincipal, new Vista.pnlRecep1());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        btn1 = new rsbuttom.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn3 = new rsbuttom.RSButtonMetro();
        btn2 = new rsbuttom.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        btn5 = new rsbuttom.RSButtonMetro();
        btnBuscarPaciente = new rsbuttom.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlMenu.setBackground(new java.awt.Color(239, 238, 244));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(239, 238, 244)));

        btn1.setForeground(new java.awt.Color(128, 128, 131));
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btn1.setText("Crear Ficha");
        btn1.setColorHover(new java.awt.Color(204, 204, 204));
        btn1.setColorNormal(new java.awt.Color(204, 204, 204));
        btn1.setColorPressed(new java.awt.Color(204, 204, 204));
        btn1.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn1.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn1.setIconTextGap(25);
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn1MousePressed(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(239, 238, 244));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(128, 128, 131));
        jLabel1.setText("Menu");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btn3.setBackground(new java.awt.Color(239, 238, 244));
        btn3.setForeground(new java.awt.Color(128, 128, 131));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chat.png"))); // NOI18N
        btn3.setText("Panel 3");
        btn3.setColorHover(new java.awt.Color(204, 204, 204));
        btn3.setColorNormal(new java.awt.Color(239, 238, 244));
        btn3.setColorPressed(new java.awt.Color(204, 204, 204));
        btn3.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn3.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn3.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn3.setIconTextGap(19);
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn3MousePressed(evt);
            }
        });
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(239, 238, 244));
        btn2.setForeground(new java.awt.Color(128, 128, 131));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/collection.png"))); // NOI18N
        btn2.setText("Panel 2");
        btn2.setColorHover(new java.awt.Color(204, 204, 204));
        btn2.setColorNormal(new java.awt.Color(239, 238, 244));
        btn2.setColorPressed(new java.awt.Color(204, 204, 204));
        btn2.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn2.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn2.setIconTextGap(25);
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn2MousePressed(evt);
            }
        });
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(239, 238, 244));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        btn5.setBackground(new java.awt.Color(239, 238, 244));
        btn5.setForeground(new java.awt.Color(128, 128, 131));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market.png"))); // NOI18N
        btn5.setText("Panel 5");
        btn5.setColorHover(new java.awt.Color(204, 204, 204));
        btn5.setColorNormal(new java.awt.Color(239, 238, 244));
        btn5.setColorPressed(new java.awt.Color(204, 204, 204));
        btn5.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn5.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn5.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn5.setIconTextGap(19);
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn5MousePressed(evt);
            }
        });
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btnBuscarPaciente.setBackground(new java.awt.Color(239, 238, 244));
        btnBuscarPaciente.setForeground(new java.awt.Color(128, 128, 131));
        btnBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/feeedback.png"))); // NOI18N
        btnBuscarPaciente.setText("Buscar Paciente");
        btnBuscarPaciente.setColorHover(new java.awt.Color(204, 204, 204));
        btnBuscarPaciente.setColorNormal(new java.awt.Color(239, 238, 244));
        btnBuscarPaciente.setColorPressed(new java.awt.Color(204, 204, 204));
        btnBuscarPaciente.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnBuscarPaciente.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnBuscarPaciente.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnBuscarPaciente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarPaciente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscarPaciente.setIconTextGap(19);
        btnBuscarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarPacienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarPacienteMousePressed(evt);
            }
        });
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 8.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(pnlMenu, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(0, 134, 190));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logo22.png"))); // NOI18N
        titulo.setText("Clinica");

        jLabel2.setText("MENU KINESIOLOGO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 624, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnlCentro.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlPrincipal);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnlCentro, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        new CambiaPanel(pnlPrincipal, new Vista.FichaMedica());
        if (this.btn1.isSelected()) {
            this.btn1.setColorNormal(new Color(204, 204, 204));
            this.btn1.setColorHover(new Color(204, 204, 204));
            this.btn1.setColorPressed(new Color(204, 204, 204));

            this.btn2.setColorNormal(new Color(239, 238, 244));
            this.btn2.setColorHover(new Color(204, 204, 204));
            this.btn2.setColorPressed(new Color(204, 204, 204));

            this.btn3.setColorNormal(new Color(239, 238, 244));
            this.btn3.setColorHover(new Color(204, 204, 204));
            this.btn3.setColorPressed(new Color(204, 204, 204));

            this.btnBuscarPaciente.setColorNormal(new Color(239, 238, 244));
            this.btnBuscarPaciente.setColorHover(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorPressed(new Color(204, 204, 204));

            this.btn5.setColorNormal(new Color(239, 238, 244));
            this.btn5.setColorHover(new Color(204, 204, 204));
            this.btn5.setColorPressed(new Color(204, 204, 204));

        } else {
            this.btn1.setColorNormal(new Color(239, 238, 244));
            this.btn1.setColorHover(new Color(204, 204, 204));
            this.btn1.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MousePressed
        this.btn1.setSelected(true);
        this.btn2.setSelected(false);
        this.btn3.setSelected(false);
        this.btnBuscarPaciente.setSelected(false);
        this.btn5.setSelected(false);

    }//GEN-LAST:event_btn1MousePressed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        new CambiaPanel(pnlPrincipal, new Vista.BuscadorPaciente());
        if (this.btn3.isSelected()) {
            this.btn3.setColorNormal(new Color(204, 204, 204));
            this.btn3.setColorHover(new Color(204, 204, 204));
            this.btn3.setColorPressed(new Color(204, 204, 204));

            this.btn1.setColorNormal(new Color(239, 238, 244));
            this.btn1.setColorHover(new Color(204, 204, 204));
            this.btn1.setColorPressed(new Color(204, 204, 204));

            this.btn2.setColorNormal(new Color(239, 238, 244));
            this.btn2.setColorHover(new Color(204, 204, 204));
            this.btn2.setColorPressed(new Color(204, 204, 204));

            this.btnBuscarPaciente.setColorNormal(new Color(239, 238, 244));
            this.btnBuscarPaciente.setColorHover(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorPressed(new Color(204, 204, 204));

            this.btn5.setColorNormal(new Color(239, 238, 244));
            this.btn5.setColorHover(new Color(204, 204, 204));
            this.btn5.setColorPressed(new Color(204, 204, 204));

        } else {
            this.btn3.setColorNormal(new Color(239, 238, 244));
            this.btn3.setColorHover(new Color(204, 204, 204));
            this.btn3.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MousePressed
        this.btn1.setSelected(false);
        this.btn2.setSelected(false);
        this.btn3.setSelected(true);
        this.btnBuscarPaciente.setSelected(false);
        this.btn5.setSelected(false);

    }//GEN-LAST:event_btn3MousePressed

    private void btn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MousePressed
        this.btn1.setSelected(false);
        this.btn2.setSelected(true);
        this.btn3.setSelected(false);
        this.btnBuscarPaciente.setSelected(false);
        this.btn5.setSelected(false);

    }//GEN-LAST:event_btn2MousePressed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        new CambiaPanel(pnlPrincipal, new Vista.pnlKine2());
        if (this.btn2.isSelected()) {
            this.btn2.setColorNormal(new Color(204, 204, 204));
            this.btn2.setColorHover(new Color(204, 204, 204));
            this.btn2.setColorPressed(new Color(204, 204, 204));

            this.btn1.setColorNormal(new Color(239, 238, 244));
            this.btn1.setColorHover(new Color(204, 204, 204));
            this.btn1.setColorPressed(new Color(204, 204, 204));

            this.btn3.setColorNormal(new Color(239, 238, 244));
            this.btn3.setColorHover(new Color(204, 204, 204));
            this.btn3.setColorPressed(new Color(204, 204, 204));

            this.btnBuscarPaciente.setColorNormal(new Color(239, 238, 244));
            this.btnBuscarPaciente.setColorHover(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorPressed(new Color(204, 204, 204));

            this.btn5.setColorNormal(new Color(239, 238, 244));
            this.btn5.setColorHover(new Color(204, 204, 204));
            this.btn5.setColorPressed(new Color(204, 204, 204));

        } else {
            this.btn2.setColorNormal(new Color(239, 238, 244));
            this.btn2.setColorHover(new Color(204, 204, 204));
            this.btn2.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        new CambiaPanel(pnlPrincipal, new Vista.pnlKine5());
        if (this.btn5.isSelected()) {
            this.btn1.setColorNormal(new Color(239, 238, 244));
            this.btn1.setColorHover(new Color(204, 204, 204));
            this.btn1.setColorPressed(new Color(204, 204, 204));

            this.btn2.setColorNormal(new Color(239, 238, 244));
            this.btn2.setColorHover(new Color(204, 204, 204));
            this.btn2.setColorPressed(new Color(204, 204, 204));

            this.btn3.setColorNormal(new Color(239, 238, 244));
            this.btn3.setColorHover(new Color(204, 204, 204));
            this.btn3.setColorPressed(new Color(204, 204, 204));

            this.btnBuscarPaciente.setColorNormal(new Color(239, 238, 244));
            this.btnBuscarPaciente.setColorHover(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorPressed(new Color(204, 204, 204));

            this.btn5.setColorNormal(new Color(204, 204, 204));
            this.btn5.setColorHover(new Color(204, 204, 204));
            this.btn5.setColorPressed(new Color(204, 204, 204));

        } else {
            this.btn5.setColorNormal(new Color(239, 238, 244));
            this.btn5.setColorHover(new Color(204, 204, 204));
            this.btn5.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MousePressed
        this.btn1.setSelected(false);
        this.btn2.setSelected(false);
        this.btn3.setSelected(false);
        this.btnBuscarPaciente.setSelected(false);
        this.btn5.setSelected(true);

    }//GEN-LAST:event_btn5MousePressed

    private void btnBuscarPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPacienteMousePressed
        this.btn1.setSelected(false);
        this.btn2.setSelected(false);
        this.btn3.setSelected(false);
        this.btnBuscarPaciente.setSelected(true);
        this.btn5.setSelected(false);

    }//GEN-LAST:event_btnBuscarPacienteMousePressed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        new CambiaPanel(pnlPrincipal, new Vista.BuscadorPaciente());
        if (this.btnBuscarPaciente.isSelected()) {
            this.btn1.setColorNormal(new Color(239, 238, 244));
            this.btn1.setColorHover(new Color(204, 204, 204));
            this.btn1.setColorPressed(new Color(204, 204, 204));

            this.btn2.setColorNormal(new Color(239, 238, 244));
            this.btn2.setColorHover(new Color(204, 204, 204));
            this.btn2.setColorPressed(new Color(204, 204, 204));

            this.btn3.setColorNormal(new Color(239, 238, 244));
            this.btn3.setColorHover(new Color(204, 204, 204));
            this.btn3.setColorPressed(new Color(204, 204, 204));

            this.btnBuscarPaciente.setColorNormal(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorHover(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorPressed(new Color(204, 204, 204));

            this.btn5.setColorNormal(new Color(239, 238, 244));
            this.btn5.setColorHover(new Color(204, 204, 204));
            this.btn5.setColorPressed(new Color(204, 204, 204));

        } else {
            this.btnBuscarPaciente.setColorNormal(new Color(239, 238, 244));
            this.btnBuscarPaciente.setColorHover(new Color(204, 204, 204));
            this.btnBuscarPaciente.setColorPressed(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnBuscarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarPacienteMouseClicked

    }//GEN-LAST:event_btnBuscarPacienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuKinesiologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuKinesiologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuKinesiologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuKinesiologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new MenuKinesiologo().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MenuKinesiologo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rsbuttom.RSButtonMetro btn1;
    public rsbuttom.RSButtonMetro btn2;
    public rsbuttom.RSButtonMetro btn3;
    public rsbuttom.RSButtonMetro btn5;
    public rsbuttom.RSButtonMetro btnBuscarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
