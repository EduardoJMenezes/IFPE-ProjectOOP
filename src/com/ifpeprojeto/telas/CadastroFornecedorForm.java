package com.ifpeprojeto.telas;

import com.ifpeprojeto.conexao.ConexaoMysql;
import java.sql.*;
import javax.swing.JOptionPane;

public class CadastroFornecedorForm extends javax.swing.JInternalFrame {
    Connection conector = null;
    PreparedStatement pst = null;

    public CadastroFornecedorForm() {
        initComponents();
        conector = ConexaoMysql.conectar();
    }
    
    public void adicionarFornecedor(){
        String sql = "INSERT INTO fornecedor(nome, cnpj, desc_fornecedor) VALUES (?, ?, ?)"; 
        
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, cadastroNome.getText());
            pst.setString(2, cadastroCNPJ.getText());
            pst.setString(3, cadastroDescricao.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso.");
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        cadastrarNome = new javax.swing.JLabel();
        cadastrarEmail = new javax.swing.JLabel();
        cadastroCNPJ = new javax.swing.JTextField();
        cadastroNome = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();
        cadastrarDescricao = new javax.swing.JLabel();
        cadastroDescricao = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.darkGray);
        setIconifiable(true);
        setResizable(true);
        setToolTipText("");
        setVisible(true);

        titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titulo.setText("CADASTRAR FORNECEDOR");

        cadastrarNome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cadastrarNome.setText("Nome: ");

        cadastrarEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cadastrarEmail.setText("CNPJ:");

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        cadastrarDescricao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cadastrarDescricao.setText("Descrição: ");

        cadastroDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastrarNome)
                            .addComponent(cadastrarEmail)
                            .addComponent(cadastrarDescricao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cadastroCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(cadastroNome)
                            .addComponent(cadastroDescricao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(titulo)))
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(titulo)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarNome)
                    .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarDescricao)
                    .addComponent(cadastroDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        adicionarFornecedor();

    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void cadastroDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroDescricaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel cadastrarDescricao;
    private javax.swing.JLabel cadastrarEmail;
    private javax.swing.JLabel cadastrarNome;
    private javax.swing.JTextField cadastroCNPJ;
    private javax.swing.JTextField cadastroDescricao;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
