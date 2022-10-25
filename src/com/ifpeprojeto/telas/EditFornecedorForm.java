package com.ifpeprojeto.telas;

import com.ifpeprojeto.conexao.ConexaoMysql;
import com.ifpeprojeto.entidades.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EditFornecedorForm extends javax.swing.JInternalFrame {

    Connection conector;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<Fornecedor> lista = new ArrayList<>();

    public EditFornecedorForm() {
        initComponents();
        conector = ConexaoMysql.conectar();
    }

    private void CarregarCampos() {
        int setar = tabelaFornecedor.getSelectedRow();

        txtIdFornecedor.setText(tabelaFornecedor.getModel().getValueAt(setar, 0).toString());
        editNome.setText(tabelaFornecedor.getModel().getValueAt(setar, 1).toString());
        editDescricao.setText(tabelaFornecedor.getModel().getValueAt(setar, 3).toString());
        editCNPJ.setText(tabelaFornecedor.getModel().getValueAt(setar, 2).toString());

    }

    public ArrayList<Fornecedor> PesquisarFornecedor() {
        String sql = "SELECT * from fornecedor";

        try {
            pst = conector.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Fornecedor objFornecedor = new Fornecedor();
                objFornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                objFornecedor.setNome(rs.getString("nome"));
                objFornecedor.setCnpj(rs.getString("cnpj"));
                objFornecedor.setDesc_fornecedor(rs.getString("desc_fornecedor"));

                lista.add(objFornecedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fornecedor pesquisar: " + e);
        }

        return lista;
    }

    private void listarValoresFornecedor() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabelaFornecedor.getModel();
            model.setNumRows(0);

            ArrayList<Fornecedor> lista = PesquisarFornecedor();

            for (int cont = 0; cont < lista.size(); cont++) {
                model.addRow(new Object[]{
                    lista.get(cont).getIdFornecedor(),
                    lista.get(cont).getNome(),
                    lista.get(cont).getCnpj(),
                    lista.get(cont).getDesc_fornecedor()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Listar valores: " + e);
        }
    }

    private void alterarFornecedor(Fornecedor objFornecedor) {

        String sql = "UPDATE fornecedor set nome = ?, cnpj = ?, desc_fornecedor = ? WHERE idFornecedor = ?";
        conector = new ConexaoMysql().conectar();

        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, objFornecedor.getNome());
            pst.setString(2, objFornecedor.getCnpj());
            pst.setString(3, objFornecedor.getDesc_fornecedor());
            pst.setInt(4, objFornecedor.getIdFornecedor());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso.");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    private void EditFornecedor() {
        int idFornecedor;
        String nome, cnpj, desc_fornecedor;

        idFornecedor = Integer.parseInt(txtIdFornecedor.getText());
        nome = editNome.getText();
        cnpj = editCNPJ.getText();
        desc_fornecedor = editDescricao.getText();

        Fornecedor objFornecedor = new Fornecedor();
        objFornecedor.setIdFornecedor(idFornecedor);
        objFornecedor.setNome(nome);
        objFornecedor.setCnpj(cnpj);
        objFornecedor.setDesc_fornecedor(desc_fornecedor);

        alterarFornecedor(objFornecedor);
    }

    private void excluirFornecedor(Fornecedor objFornecedor) {
        String sql = "DELETE from fornecedor WHERE idFornecedor = ?";
        conector = new ConexaoMysql().conectar();

        try {
            pst = conector.prepareStatement(sql);
            pst.setInt(1, objFornecedor.getIdFornecedor());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso.");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Fornecedor Excluir" + e);
        }

    }

    private void ExcluirFornecedor() {
        int idFornecedor;

        idFornecedor = Integer.parseInt(txtIdFornecedor.getText());

        Fornecedor objFornecedor = new Fornecedor();
        objFornecedor.setIdFornecedor(idFornecedor);

        excluirFornecedor(objFornecedor);

    }

    private void LimparCamposEdit() {
        editNome.setText("");
        editDescricao.setText("");
        editCNPJ.setText("");
        txtIdFornecedor.setText("");
        editNome.requestFocus();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editNome = new javax.swing.JTextField();
        editarButton = new javax.swing.JButton();
        editarNome = new javax.swing.JLabel();
        editarEmail = new javax.swing.JLabel();
        editDescricao = new javax.swing.JTextField();
        JScrollPanel = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        tituloEditar = new javax.swing.JLabel();
        buscarFornecedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdFornecedor = new javax.swing.JTextField();
        carregarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        limparEditButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        editCNPJ = new javax.swing.JTextField();
        deletar = new javax.swing.JButton();

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
        editarEmail.setText("CNPJ:");

        tabelaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CNPJ", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JScrollPanel.setViewportView(tabelaFornecedor);

        tituloEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloEditar.setText("EDITAR FORNECEDOR");

        buscarFornecedor.setText("Buscar");
        buscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFornecedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("iD:");

        txtIdFornecedor.setEnabled(false);
        txtIdFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdFornecedorActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Descricao:");

        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(tituloEditar)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarFornecedor)
                                .addGap(12, 12, 12)
                                .addComponent(carregarButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editarNome)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editarEmail)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(limparEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(editCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(tituloEditar)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editarNome))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarEmail)
                            .addComponent(editCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(editDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limparEditButton)
                            .addComponent(editarButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(JScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(limparButton)
                        .addGap(36, 36, 36))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        EditFornecedor();
        lista.clear();
        listarValoresFornecedor();
        LimparCamposEdit();

    }//GEN-LAST:event_editarButtonActionPerformed

    private void buscarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFornecedorActionPerformed
        lista.clear();
        listarValoresFornecedor();

    }//GEN-LAST:event_buscarFornecedorActionPerformed

    private void txtIdFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdFornecedorActionPerformed

    }//GEN-LAST:event_txtIdFornecedorActionPerformed

    private void editNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNomeActionPerformed

    }//GEN-LAST:event_editNomeActionPerformed

    private void carregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarButtonActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_carregarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        ((DefaultTableModel)tabelaFornecedor.getModel()).setRowCount(0);
        lista.clear();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void limparEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparEditButtonActionPerformed
        LimparCamposEdit();
    }//GEN-LAST:event_limparEditButtonActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        ExcluirFornecedor();
        lista.clear();
        listarValoresFornecedor();
        LimparCamposEdit();
    }//GEN-LAST:event_deletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPanel;
    private javax.swing.JButton buscarFornecedor;
    private javax.swing.JButton carregarButton;
    private javax.swing.JButton deletar;
    private javax.swing.JTextField editCNPJ;
    private javax.swing.JTextField editDescricao;
    private javax.swing.JTextField editNome;
    private javax.swing.JButton editarButton;
    private javax.swing.JLabel editarEmail;
    private javax.swing.JLabel editarNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton limparEditButton;
    private javax.swing.JTable tabelaFornecedor;
    private javax.swing.JLabel tituloEditar;
    private javax.swing.JTextField txtIdFornecedor;
    // End of variables declaration//GEN-END:variables
}
