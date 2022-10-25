package com.ifpeprojeto.conexao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoMysql {
    public static Connection conectar() {

    java.sql.Connection conector = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String USUARIO = "root";
    String SENHA = "root";
    String URL = "jdbc:mysql://127.0.0.1:3306/projeto"; 

    try {
        Class.forName(driver);
        conector = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conector;
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        return null;
        }
    }
}
