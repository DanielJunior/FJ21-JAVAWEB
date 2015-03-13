/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DAOException;
import factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelos.Contato;

/**
 *
 * @author danieljunior
 */
public class ContatoDao {

    private Connection connection;

    public ContatoDao() {
        connection = new ConnectionFactory().getConnection();
    }

    public ContatoDao(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Contato contato) {
        String sql = " insert into contatos"
                + "(nome,email,endereco,dataNascimento)"
                + "values (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

            stmt.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> lista = new ArrayList<>();
            PreparedStatement p = connection.prepareStatement("select * from contatos");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Contato c = new Contato();
                c.setId(r.getLong("id"));
                c.setNome(r.getString("nome"));
                c.setEmail(r.getString("email"));
                c.setEndereco(r.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(r.getDate("dataNascimento"));
                c.setDataNascimento(data);
                lista.add(c);
            }
            r.close();
            p.close();
            return lista;
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    public Contato pesquisar(long id) {
        try {
            System.out.println(id);
            PreparedStatement stmt = connection.prepareStatement("select * from contatos where id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Contato c = new Contato();
            while (rs.next()) {
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                c.setDataNascimento(data);
            }
            return c;
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    public void alterar(Contato c) {
        try {
            PreparedStatement stmt = connection.prepareStatement("update contatos set nome =?,email =?,endereco=?,dataNascimento=? where id=?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getEndereco());
            stmt.setDate(4, new Date(c.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, c.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    public void remove(Contato c) {
        try {
            PreparedStatement p = connection.prepareStatement("delete from contatos where id=?");
            p.setLong(1, c.getId());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

}
