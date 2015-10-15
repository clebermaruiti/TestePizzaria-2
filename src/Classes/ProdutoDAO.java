/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import BancoDados.ConexaoBancoDados;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class ProdutoDAO {

    ConexaoBancoDados banco = new ConexaoBancoDados();

    public ProdutoDAO() {

    }

    public void insert(Produto p) throws SQLException {

        PreparedStatement ps = banco.conn.prepareStatement("insert into produto(produto,descricao)values(?,?)");
        ps.setString(1, p.getProduto());
        ps.setString(2, p.getDescricao());

        ps.execute();
        JOptionPane.showMessageDialog(null, "Cadastro concluido", "Produto", 1);

    

    }

    public void delete(Produto p) throws SQLException {

        banco.st = banco.conn.createStatement();
        banco.st.executeUpdate("delete from produto where produto ='" + p.getProduto() + "'");

    }

    public void update(Produto p) throws SQLException {

        banco.st = banco.conn.createStatement();
        banco.rs = banco.st.executeQuery("select * from produto where produto ='" + p.getProduto() + "'");

        if (banco.rs.next()) {
            banco.st.executeUpdate("Update produto set descricao ='" + p.getDescricao() + "' where produto='" + p.getProduto() + "'");
            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Update", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Codigo nao cadastrado", "Update", 2);
        }

    }

    public void select(Produto p) throws SQLException {

        banco.st = banco.conn.createStatement();
        banco.rs = banco.st.executeQuery("select from produto where produto ='" + p.getProduto() + "'");

        if (banco.rs.next()) {

            p.setProduto(banco.rs.getString("produto"));
            p.setDescricao(banco.rs.getString("descricao"));

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Dado Encontrado para o produto de codigo " + p.getProduto());

        }
    }
}
