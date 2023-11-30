package lk.ijse.chicagosystem.model;

import lk.ijse.chicagosystem.to.Feedback;
import lk.ijse.chicagosystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackModel {
    public static ResultSet getFeeedback() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT *from feedback");
    }


    public static boolean save(Feedback feedback) throws SQLException, ClassNotFoundException {
        System.out.println(feedback.getOrderid());
        return CrudUtil.execute("INSERT INTO feedback VALUES (?,?,?,?,?)",
                feedback.getFbNo(),
                feedback.getFbTitle(),
                feedback.getFbDescription(),
                feedback.getRatings(),
                feedback.getOrderid()

        );
    }

    public static ResultSet getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT fbNo FROM feedback ORDER BY fbNo DESC LIMIT 1");
    }
}
