package com.http.shiller.jdbc.dao;

import com.http.shiller.jdbc.config.ConnectionManager;
import com.http.shiller.jdbc.dao.entity.Pad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotesDaoImpl {

    public static void main(String[] args) throws SQLException {
        NotesDaoImpl dao = new NotesDaoImpl();
        List<Pad> pads = dao.selectAllPads();
        System.out.println(pads);
    }

    private static final String INSERT_INTO_PADS = "INSERT INTO pads (name) VALUES (?)";
    private static final String SELECT_PADS = "SELECT * FROM pads";

    public Object transactionExmpl() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.take();
            connection.setAutoCommit(false);
            //updating logic
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public void insertPad(Pad pad) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionManager.take();
            statement = connection.prepareStatement(INSERT_INTO_PADS);
            statement.setString(1, pad.getName());
            int i = statement.executeUpdate();
            if (i != 1) {
                System.out.println("ERROR");
            }
        } finally {
            ConnectionManager.close(null, statement, connection);
        }
    }

    public List<Pad> selectAllPads() throws SQLException {
        List<Pad> result = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.take();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_PADS);

            Pad pad;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                pad = new Pad();
                pad.setName(name);
                pad.setId(id);
                result.add(pad);
            }
        } finally {
            ConnectionManager.close(resultSet, statement, connection);
        }
        return result;
    }
}
