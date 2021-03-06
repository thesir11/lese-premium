/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.model.dao;

import game.lese.connection.DBConnection;
import game.lese.model.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class AnswerDAO {
    
    public static int createAnswer(Answer answer){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement("INSERT INTO answer(question, description, status) VALUES(?, ?, ?)");
            ps.setInt(1, answer.getQuestion().getQuestionId());
            ps.setString(2, answer.getDescription());
            ps.setString(3, answer.getStatus());
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DBConnection.closeConnection(connection, ps);
        }
        return 0;
    }
    
    public static int updateAnswer(Answer answer) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement("UPDATE answer SET question = ?, description = ?, status = ? WHERE id_answer = ?");
            ps.setInt(1, answer.getQuestion().getQuestionId());
            ps.setString(2, answer.getDescription());
            ps.setString(3, answer.getStatus());
            ps.setInt(4, answer.getIdAnswer());
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DBConnection.closeConnection(connection, ps);
        }
        return 0;
    }
    
    public static int deleteAnswer(Answer answer) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement("DELETE FROM answer WHERE id_answer = ?");
            ps.setInt(1, answer.getIdAnswer());
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DBConnection.closeConnection(connection, ps);
        }
        return 0;
    }
    
    public static List<Answer> selectAnswerPerQuestionId(int QuestionId){
        Connection connection = null;
        PreparedStatement ps = null;
        List<Answer> listAnswers = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement("SELECT * FROM answer WHERE question=?");
            ps.setInt(1, QuestionId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Answer answer = new Answer();
                answer.setIdAnswer(rs.getInt("id_answer"));
                answer.setDescription(rs.getString("description"));
                answer.setStatus(rs.getString("status"));
                listAnswers.add(answer);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DBConnection.closeConnection(connection, ps);
        }
        return listAnswers;
    }
    
}
