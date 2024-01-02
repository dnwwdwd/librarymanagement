package SQLOperation.BorrowOperation;

import utils.Utils;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BorrowOperation{
    public static void borrowinsert(String id,String booknum,String borrowdate,String returndate)throws Exception{
        String insertsql="insert into borrowrecord(stu_id,book_id,borrow_date,return_date) values(?,?,?,?)";
        String borrowbooksql="update books set book_stock=book_stock - 1 where book_num=?";
        Connection connection1= Utils.getConnection();
        PreparedStatement insertsqlpreparedStatement=connection1.prepareStatement(insertsql);
        insertsqlpreparedStatement.setString(1,id);
        insertsqlpreparedStatement.setString(2,booknum);
        insertsqlpreparedStatement.setString(3,borrowdate);
        insertsqlpreparedStatement.setString(4,returndate);
        Connection connection2=Utils.getConnection();
        PreparedStatement borrowbooksqlpreparedStatement=connection2.prepareStatement(borrowbooksql);
        borrowbooksqlpreparedStatement.setString(1,booknum);
        int i=insertsqlpreparedStatement.executeUpdate();
        int j=borrowbooksqlpreparedStatement.executeUpdate();
        Utils.Close(insertsqlpreparedStatement,connection1);
        Utils.Close(borrowbooksqlpreparedStatement,connection2);
    }
    public static void borrowdelete(String id,String booknum)throws Exception{
        String deletesql="delete from borrowrecord where stu_id=? and book_id=?";
        String returnbooksql="update books set book_stock=book_stock + 1 where book_num=?";
        Connection connection1= Utils.getConnection();
        PreparedStatement deletesqlpreparedStatement = connection1.prepareStatement(deletesql);
        deletesqlpreparedStatement.setString(1,id);
        deletesqlpreparedStatement.setString(2,booknum);
        Connection connection2=Utils.getConnection();
        PreparedStatement returnbooksqlpreparedStatement= connection2.prepareStatement(returnbooksql);
        returnbooksqlpreparedStatement.setString(1,booknum);
        int i=deletesqlpreparedStatement.executeUpdate();
        int j=returnbooksqlpreparedStatement.executeUpdate();
        Utils.Close(deletesqlpreparedStatement,connection1);
        Utils.Close(returnbooksqlpreparedStatement,connection2);
    }
    public static void borrowquery(DefaultTableModel model)throws Exception{
        String sql="select stu_id,book_id,borrow_date,return_date from borrowrecord";
        Connection connection=Utils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            String stuid=rs.getString("stu_id");
            String bookid=rs.getString("book_id");
            String borrowdate= rs.getString("borrow_date");
            String returndate=rs.getString("return_date");
            model.addRow(new Object[]{stuid,bookid,borrowdate,returndate});
        }
        Utils.Close(rs,statement,connection);
    }
}
