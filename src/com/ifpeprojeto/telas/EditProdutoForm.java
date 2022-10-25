package com.ifpeprojeto.telas;

import com.ifpeprojeto.conexao.ConexaoMysql;
import com.ifpeprojeto.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class EditProdutoForm extends javax.swing.JInternalFrame {

    Connection conector;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<Produto> lista = new ArrayList<>();
  
    public EditProdutoForm() {
        initComponents();
        conector = ConexaoMysql.conectar();
    }

    private void CarregarCampos() {
        int setar = tabelaProduto.getSelectedRow();

        txtidproduto.setText(tabelaProduto.getModel().getValueAt(setar, 0).toString());
        editNome.setText(tabelaProduto.getModel().getValueAt(setar, 1).toString());
        editPreco.setText(tabelaProduto.getModel().getValueAt(setar, 2).toString());

    }

    public ArrayList<Produto> PesquisarProduto() {
        String sql = "SELECT * from produto";

        try {
            pst = conector.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Produto objProduto = new Produto();
                objProduto.setIdProduto(rs.getInt("idProduto"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setPreco(rs.getString("preco"));

                lista.add(objProduto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto pesquisar: " + e);
        }

        return lista;
    }

    private void listarValoresProduto() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
            model.setNumRows(0);

            ArrayList<Produto> lista = PesquisarProduto();

            for (int cont = 0; cont < lista.size(); cont++) {
                model.addRow(new Object[]{
                    lista.get(cont).getIdProduto(),
                    lista.get(cont).getNome(),
                    lista.get(cont).getPreco()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Listar valores: " + e);
        }
    }

    private void alterarProduto(Produto objProduto) {

        String sql = "UPDATE produto set nome = ?, preco = ? where idProduto = ?";
        conector = new ConexaoMysql().conectar();

        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, objProduto.getNome());
            pst.setString(2, objProduto.getPreco());
            pst.setInt(3, objProduto.getIdProduto());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso.");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    
    }

    private void EditProduto() {
        int idProduto;
        String nome, preco;

        idProduto = Integer.parseInt(txtidproduto.getText());
        nome = editNome.getText();
        preco = editPreco.getText();

        Produto objProduto = new Produto();
        objProduto.setIdProduto(idProduto);
        objProduto.setNome(nome);
        objProduto.setPreco(preco);

        alterarProduto(objProduto);
    }
    
    private void excluirProduto(Produto objProduto) {
        String sql = "DELETE from produto WHERE idProduto = ?";
        conector = new ConexaoMysql().conectar();

        try {
            pst = conector.prepareStatement(sql);
            pst.setInt(1, objProduto.getIdProduto());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Produto Excluir" + e);
        }

    }

    private void ExcluirProduto() {
        int idProduto;

        idProduto = Integer.parseInt(txtidproduto.getText());

        Produto objproduto = new Produto();
        objproduto.setIdProduto(idProduto);

        excluirProduto(objproduto);
    }
    
    
    private void LimparCamposEdit(){
        editNome.setText("");
        editPreco.setText("");
        txtidproduto.setText("");
        editNome.requestFocus();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editNome = new javax.swing.JTextField();
        editarButton = new javax.swing.JButton();
        editarNome = new javax.swing.JLabel();
        editarEmail = new javax.swing.JLabel();
        editPreco = new javax.swing.JTextField();
        JScrollPanel = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        tituloEditar = new javax.swing.JLabel();
        buscarProduto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtidproduto = new javax.swing.JTextField();
        carregarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        limparEditButton = new javax.swing.JButton();
        deletarButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setRequestFocusEnabled(false);

        editNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNomeActionPerformed(evt);
            }
        });

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        editarNome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        editarNome.setText("Nome: ");

        editarEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        editarEmail.setText("Preço:");

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JScrollPanel.setViewportView(tabelaProduto);

        tituloEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloEditar.setText("EDITAR PRODUTO");

        buscarProduto.setText("Buscar");
        buscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProdutoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("iD:");

        txtidproduto.setEnabled(false);
        txtidproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidprodutoActionPerformed(evt);
            }
        });

        carregarButton.setText("Carregar Campo");
        carregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarButtonActionPerformed(evt);
            }
        });

        limparButton.setText("Limpar Tabela");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        limparEditButton.setText("Limpar");
        limparEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparEditButtonActionPerformed(evt);
            }
        });

        deletarButton.setText("Deletar");
        deletarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deletarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carregarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(editarNome)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtidproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(editarEmail)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(limparEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tituloEditar)
                        .addGap(67, 67, 67)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(JScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deletarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscarProduto)
                                .addComponent(carregarButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(tituloEditar)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editarNome))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editarEmail))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarButton)
                            .addComponent(limparEditButton))))
                .addGap(18, 18, 18)
                .addComponent(limparButton)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        EditProduto();
        lista.clear();
        listarValoresProduto();
        LimparCamposEdit();
 
    }//GEN-LAST:event_editarButtonActionPerformed

    private void buscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProdutoActionPerformed
        lista.clear();
        listarValoresProduto();
        
    }//GEN-LAST:event_buscarProdutoActionPerformed

    private void txtidprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidprodutoActionPerformed

    }//GEN-LAST:event_txtidprodutoActionPerformed

    private void editNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNomeActionPerformed

    }//GEN-LAST:event_editNomeActionPerformed

    private void carregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarButtonActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_carregarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        ((DefaultTableModel)tabelaProduto.getModel()).setRowCount(0);
        lista.clear();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void limparEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparEditButtonActionPerformed
        LimparCamposEdit();
    }//GEN-LAST:event_limparEditButtonActionPerformed

    private void deletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarButtonActionPerformed
        ExcluirProduto();
        lista.clear();
        listarValoresProduto();
        LimparCamposEdit();
    }//GEN-LAST:event_deletarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPanel;
    private javax.swing.JButton buscarProduto;
    private javax.swing.JButton carregarButton;
    private javax.swing.JButton deletarButton;
    private javax.swing.JTextField editNome;
    private javax.swing.JTextField editPreco;
    private javax.swing.JButton editarButton;
    private javax.swing.JLabel editarEmail;
    private javax.swing.JLabel editarNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton limparEditButton;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JLabel tituloEditar;
    private javax.swing.JTextField txtidproduto;
    // End of variables declaration//GEN-END:variables
}
