package com.ifpeprojeto.telas;

import com.ifpeprojeto.conexao.ConexaoMysql;
import java.sql.*;
import javax.swing.JOptionPane;

public class CadastroFuncionarioForm extends javax.swing.JInternalFrame {
    Connection conector = null;
    PreparedStatement pst = null;

    public CadastroFuncionarioForm() {
        initComponents();
        conector = ConexaoMysql.conectar();
    }
    
    public void adicionarFuncionario(){
        String sql = "INSERT INTO funcionario(nome, salario) VALUES (?, ?)"; 
        
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, cadastroNome.getText());
            pst.setString(2, cadastroSalario.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso.");
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        cadastrarNome = new javax.swing.JLabel();
        cadastrarEmail = new javax.swing.JLabel();
        cadastroSalario = new javax.swing.JTextField();
        cadastroNome = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.darkGray);
        setIconifiable(true);
        setResizable(true);
        setToolTipText("");
        setVisible(true);

        titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titulo.setText("CADASTRAR FUNCIONARIO");

        cadastrarNome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cadastrarNome.setText("Nome: ");

        cadastrarEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cadastrarEmail.setText("Salario:");

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastrarNome)
                            .addComponent(cadastrarEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cadastroSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(cadastroNome)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(249, 249, 249))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titulo)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarNome)
                    .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarEmail))
                .addGap(43, 43, 43)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        adicionarFuncionario();
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel cadastrarEmail;
    private javax.swing.JLabel cadastrarNome;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JTextField cadastroSalario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
