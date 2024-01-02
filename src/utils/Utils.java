package utils;

import java.sql.*;

public class Utils {
    private static final String Drivername="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/librarymanagement?characterEncoding=utf8";
    private static final String username="root";
    private static final String password="123456";
    static {
        try{
            Class.forName(Drivername);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection=null;
        try{
            connection=DriverManager.getConnection(url,username,password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public static void Close(Statement statement,Connection connection){
        Close(null,statement,connection);
    }
    public static void Close(ResultSet resultSet,Statement statement,Connection connection){
        try{
            if(resultSet!=null && !resultSet.isClosed()){
                resultSet.close();
            }
            if(statement!=null && !statement.isClosed()){
                statement.close();
            }
            if(connection!=null && !connection.isClosed()){
                connection.close();
            }
        }
        catch(Exception e){
            System.out.println("关闭数据库失败");
        }
    }
}
