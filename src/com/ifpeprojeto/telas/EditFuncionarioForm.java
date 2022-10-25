package com.ifpeprojeto.telas;

import com.ifpeprojeto.conexao.ConexaoMysql;
import com.ifpeprojeto.entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EditFuncionarioForm extends javax.swing.JInternalFrame {

    Connection conector;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<Funcionario> lista = new ArrayList<>();

    public EditFuncionarioForm() {
        initComponents();
        conector = ConexaoMysql.conectar();
    }

    private void CarregarCampos() {
        int setar = tabelaFuncionario.getSelectedRow();

        txtIdFuncionario.setText(tabelaFuncionario.getModel().getValueAt(setar, 0).toString());
        editNome.setText(tabelaFuncionario.getModel().getValueAt(setar, 1).toString());
        editSalario.setText(tabelaFuncionario.getModel().getValueAt(setar, 2).toString());

    }

    public ArrayList<Funcionario> PesquisarFuncionario() {
        String sql = "SELECT * from funcionario";

        try {
            pst = conector.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Funcionario objfuncionario = new Funcionario();
                objfuncionario.setidFuncionario(rs.getInt("idfuncionario"));
                objfuncionario.setNome(rs.getString("nome"));
                objfuncionario.setSalario(rs.getString("salario"));

                lista.add(objfuncionario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Funcionario pesquisar: " + e);
        }

        return lista;
    }

    private void listarValoresFuncionario() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabelaFuncionario.getModel();
            model.setNumRows(0);

            ArrayList<Funcionario> lista = PesquisarFuncionario();

            for (int cont = 0; cont < lista.size(); cont++) {
                model.addRow(new Object[]{
                    lista.get(cont).getidFuncionario(),
                    lista.get(cont).getNome(),
                    lista.get(cont).getSalario()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Listar valores: " + e);
        }
    }

    private void alterarFuncionario(Funcionario objfuncionariobanco) {

        String sql = "UPDATE funcionario set nome = ?, salario = ? where idFuncionario=?";
        conector = new ConexaoMysql().conectar();

        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, objfuncionariobanco.getNome());
            pst.setString(2, objfuncionariobanco.getSalario());
            pst.setInt(3, objfuncionariobanco.getidFuncionario());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Funcionario editado com sucesso.");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    private void EditFuncionario() {
        int idFuncionario;
        String nome, salario;

        idFuncionario = Integer.parseInt(txtIdFuncionario.getText());
        nome = editNome.getText();
        salario = editSalario.getText();

        Funcionario objfuncionariobanco = new Funcionario();
        objfuncionariobanco.setidFuncionario(idFuncionario);
        objfuncionariobanco.setNome(nome);
        objfuncionariobanco.setSalario(salario);

        alterarFuncionario(objfuncionariobanco);
    }

    private void excluirFuncionario(Funcionario objFuncionario) {
        String sql = "DELETE from funcionario WHERE idFuncionario = ?";
        conector = new ConexaoMysql().conectar();

        try {
            pst = conector.prepareStatement(sql);
            pst.setInt(1, objFuncionario.getidFuncionario());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Funcionario excluído com sucesso.");

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Funcionario Excluir" + e);
        }

    }

    private void ExcluirFuncionario() {
        int idFuncionario;

        idFuncionario = Integer.parseInt(txtIdFuncionario.getText());

        Funcionario objFuncionario = new Funcionario();
        objFuncionario.setidFuncionario(idFuncionario);

        excluirFuncionario(objFuncionario);
    }

    private void LimparCamposEdit() {
        editNome.setText("");
        editSalario.setText("");
        txtIdFuncionario.setText("");
        editNome.requestFocus();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editNome = new javax.swing.JTextField();
        editarButton = new javax.swing.JButton();
        editarNome = new javax.swing.JLabel();
        editarEmail = new javax.swing.JLabel();
        editSalario = new javax.swing.JTextField();
        JScrollPanel = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        tituloEditar = new javax.swing.JLabel();
        buscarFuncionario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdFuncionario = new javax.swing.JTextField();
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
        editarEmail.setText("Salário:");

        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Nome", "Salário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JScrollPanel.setViewportView(tabelaFuncionario);

        tituloEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tituloEditar.setText("EDITAR FUNCIONARIO");

        buscarFuncionario.setText("Buscar");
        buscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFuncionarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("iD:");

        txtIdFuncionario.setEnabled(false);
        txtIdFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdFuncionarioActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloEditar)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deletarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carregarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editarNome)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editarEmail)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(limparEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deletarButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(carregarButton)
                                .addComponent(buscarFuncionario))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloEditar)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editarNome))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        EditFuncionario();
        lista.clear();
        listarValoresFuncionario();
        LimparCamposEdit();

    }//GEN-LAST:event_editarButtonActionPerformed

    private void buscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFuncionarioActionPerformed
        lista.clear();
        listarValoresFuncionario();

    }//GEN-LAST:event_buscarFuncionarioActionPerformed

    private void txtIdFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdFuncionarioActionPerformed

    }//GEN-LAST:event_txtIdFuncionarioActionPerformed

    private void editNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNomeActionPerformed

    }//GEN-LAST:event_editNomeActionPerformed

    private void carregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarButtonActionPerformed
        CarregarCampos();
    }//GEN-LAST:event_carregarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        ((DefaultTableModel)tabelaFuncionario.getModel()).setRowCount(0);
        lista.clear();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void limparEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparEditButtonActionPerformed
        LimparCamposEdit();
    }//GEN-LAST:event_limparEditButtonActionPerformed

    private void deletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarButtonActionPerformed
        ExcluirFuncionario();
        lista.clear();
        listarValoresFuncionario();
        LimparCamposEdit();
    }//GEN-LAST:event_deletarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPanel;
    private javax.swing.JButton buscarFuncionario;
    private javax.swing.JButton carregarButton;
    private javax.swing.JButton deletarButton;
    private javax.swing.JTextField editNome;
    private javax.swing.JTextField editSalario;
    private javax.swing.JButton editarButton;
    private javax.swing.JLabel editarEmail;
    private javax.swing.JLabel editarNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton limparEditButton;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JLabel tituloEditar;
    private javax.swing.JTextField txtIdFuncionario;
    // End of variables declaration//GEN-END:variables
}
