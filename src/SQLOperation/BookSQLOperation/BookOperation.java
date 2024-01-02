package SQLOperation.BookSQLOperation;

import utils.Utils;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookOperation {
    public static void bookinsert(String name,String author,String publisher,String num,int stock)throws Exception{
        String sql="insert into books(book_name,book_author,book_publisher,book_num,book_stock) values(?,?,?,?,?)";
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,author);
        preparedStatement.setString(3,publisher);
        preparedStatement.setString(4,num);
        preparedStatement.setInt(5,stock);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void bookdelete(String num)throws Exception{
        String sql="delete from books where book_num=?";
        Connection connection=Utils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,num);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void bookupdate(String oldnum,String name,String author,String publisher,String num,int stock)throws Exception{
        String sql="update books set book_name=?,book_author=?,book_publisher=?,book_num=?,book_stock=? where book_num=?";
        Connection connection=Utils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,author);
        preparedStatement.setString(3,publisher);
        preparedStatement.setString(4,num);
        preparedStatement.setInt(5,stock);
        preparedStatement.setString(6,oldnum);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void bookquery(DefaultTableModel model)throws Exception{
        String sql="select book_name,book_author,book_publisher,book_num,book_stock from books";
        Connection connection=Utils.getConnection();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            String bookname=rs.getString("book_name");
            String bookauthor=rs.getString("book_author");
            String bookpublisher=rs.getString("book_publisher");
            String booknum=rs.getString("book_num");
            String bookstock=rs.getString("book_stock");
            model.addRow(new Object[]{bookname,bookauthor,bookpublisher,booknum,bookstock});
        }
        Utils.Close(rs,statement,connection);
    }
}
