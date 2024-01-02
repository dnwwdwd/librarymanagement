package SQLOperation.StuSQLOperation;

import utils.Utils;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class StuOperation {
    public static void stuinsert(String name,String gender,String id) throws Exception {
        String sql="insert into stu(name,gender,id) values(?,?,?)";
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,gender);
        preparedStatement.setString(3,id);
        int i= preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void studelete(String id)throws Exception{
        String sql="delete from stu where id=?";
        Connection connection=Utils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        int i= preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void stuupdate(String oldid,String name,String gender,String id)throws Exception{
        String sql="update stu set name=?,gender=?,id=? where id=?";
        Connection connection=Utils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,gender);
        preparedStatement.setString(3,id);
        preparedStatement.setString(4,oldid);
        int i=preparedStatement.executeUpdate();
        Utils.Close(preparedStatement,connection);
    }
    public static void stuquery(DefaultTableModel model)throws Exception{
        String sql="select name,gender,id from stu";
        Connection connection=Utils.getConnection();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            String name=rs.getString("name");
            String gender=rs.getString("gender");
            String id=rs.getString("id");
            model.addRow(new Object[]{name,gender,id});
        }
        Utils.Close(rs,statement,connection);
    }
}
