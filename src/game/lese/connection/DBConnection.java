/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class DBConnection {
    
    public static Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lese.sqlite");
        } catch (ClassNotFoundException ex) {
            String errorMessage = "Driver não encontrado!";
            throw new ClassNotFoundException(errorMessage, ex);
        } catch (SQLException ex) {
            String errorMessage = "Erro ao estabelecer conexão!";
            throw new ClassNotFoundException(errorMessage, ex);
        }
        return connection;
    }

    public static final void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível fechar a conexão!" + e.getCause());
        }
    }

    public static final void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível fechar a conexão!" + e.getCause());
        }
        closeConnection(connection);
    }

    public static final void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível fechar a conexão!" + e.getCause());
        }
        closeConnection(connection, statement);
    }

}
