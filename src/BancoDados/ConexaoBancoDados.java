/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDados;

/**
 *
 * @author Diogo
 */
import java.sql.*; //Importa toda e qualquer biblioteca do java.sql
import java.util.*; // Importa toda e qualquer biblioteca do java.util

import javax.swing.JOptionPane;

public class ConexaoBancoDados { // Classe responsavel pela conexao com o banco de dados

    public static Statement st; // Preparacao para conectar com o banco de dados (java.sql)
    public static ResultSet rs; // Resultado da conexao com o banco de dados (java.sql)
    public static Connection conn; // ConexaoBancoDados com o banco de dados (java.sql)
    private String driverBanco = "org.postgresql.Driver"; // Identifica o servico de banco de dados
    private String caminhoBanco = "jdbc:postgresql:pizzaria"; // Setar o local do bando de dados
    private String usuario = "postgres"; // Usuario do banco de dados
    private String senha = "adm"; // Senha do usuario do banco de dados

    public void conectaBancoDados() { // conecta ao banco de dados
        try { // Tentativa inicial de conexao
            System.setProperty("jdbc.Driver", driverBanco); //Seta a propriedade do banco de dados       
            conn = DriverManager.getConnection(caminhoBanco, usuario, senha); // Conexao com o banco de dados
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao banco de dados!"); // Mensagem para o usuario
        } catch (SQLException ex) { // excessao do erro
            JOptionPane.showMessageDialog(null, "Erro na conexao! \n Erro: " + ex.getMessage()); // Mensagem para o usuario
        }
    }

    public void desconectaBancoDados() { // desconecta ao banco de dados
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Desconectado com sucesso!"); // Mensagem para o usuario
        } catch (SQLException ex) { // excessao do erro
            JOptionPane.showMessageDialog(null, "Erro na conexao! \n Erro: " + ex.getMessage()); // Mensagem para o usuario
        }
    }
}
