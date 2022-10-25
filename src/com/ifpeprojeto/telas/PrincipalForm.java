package com.ifpeprojeto.telas;

import javax.swing.JFrame;

public class PrincipalForm extends javax.swing.JFrame {

    public PrincipalForm() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        cadastrarCliente1 = new javax.swing.JButton();
        editCliente = new javax.swing.JButton();
        cadastrarProduto = new javax.swing.JButton();
        editProduto = new javax.swing.JButton();
        painelDesktop = new javax.swing.JDesktopPane();
        cadastrarFornecedor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        titulo.setText("GERENCIAMENTO DO SUPERMERCADO");

        cadastrarCliente1.setText("Cadastrar Funcionário");
        cadastrarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCliente1ActionPerformed(evt);
            }
        });

        editCliente.setText("Pesquisar / Editar Funcionário");
        editCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClienteActionPerformed(evt);
            }
        });

        cadastrarProduto.setText("Cadastrar Produto");
        cadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProdutoActionPerformed(evt);
            }
        });

        editProduto.setText("Pesquisar / Editar Produto");
        editProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProdutoActionPerformed(evt);
            }
        });

        painelDesktop.setPreferredSize(new java.awt.Dimension(755, 400));

        javax.swing.GroupLayout painelDesktopLayout = new javax.swing.GroupLayout(painelDesktop);
        painelDesktop.setLayout(painelDesktopLayout);
        painelDesktopLayout.setHorizontalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        painelDesktopLayout.setVerticalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        cadastrarFornecedor.setText("Cadastrar Fornecedor");
        cadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFornecedorActionPerformed(evt);
            }
        });

        jButton1.setText("Pesquisar / Editar Fornecedor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cadastrarCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cadastrarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(cadastrarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cadastrarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarCliente1ActionPerformed
        CadastroFuncionarioForm cadastroCliente = new CadastroFuncionarioForm();
        cadastroCliente.setVisible(true);
        painelDesktop.add(cadastroCliente);
        System.out.println("Cadastrar Cliente");
    }//GEN-LAST:event_cadastrarCliente1ActionPerformed

    private void editClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClienteActionPerformed
        EditFuncionarioForm editCliente = new EditFuncionarioForm();
        editCliente.setVisible(true);
        painelDesktop.add(editCliente);
        System.out.println("Editar Cliente");
    }//GEN-LAST:event_editClienteActionPerformed

    private void cadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProdutoActionPerformed
        CadastroProdutoForm cadastroProduto = new CadastroProdutoForm();
        cadastroProduto.setVisible(true);
        painelDesktop.add(cadastroProduto);

    }//GEN-LAST:event_cadastrarProdutoActionPerformed

    private void editProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProdutoActionPerformed
        EditProdutoForm editProduto = new EditProdutoForm();
        editProduto.setVisible(true);
        painelDesktop.add(editProduto);
        
    }//GEN-LAST:event_editProdutoActionPerformed

    private void cadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFornecedorActionPerformed
        CadastroFornecedorForm cadastroFornecedor = new CadastroFornecedorForm();
        cadastroFornecedor.setVisible(true);
        painelDesktop.add(cadastroFornecedor);
    }//GEN-LAST:event_cadastrarFornecedorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EditFornecedorForm editFornecedor = new EditFornecedorForm();
        editFornecedor.setVisible(true);
        painelDesktop.add(editFornecedor);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /*new PrincipalForm().setVisible(true);*/
                JFrame janela = new PrincipalForm();
                janela.setResizable(false);
                janela.setVisible(true);
                janela.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarCliente1;
    private javax.swing.JButton cadastrarFornecedor;
    private javax.swing.JButton cadastrarProduto;
    private javax.swing.JButton editCliente;
    private javax.swing.JButton editProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane painelDesktop;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
