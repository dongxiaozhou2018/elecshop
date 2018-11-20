package com.neuedu.dao;

import java.sql.*;

public class UserDao {

    static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        Connection connection =null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newshop", "root", "666666");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //判断用户名是否存在
    public  boolean isExists(String username,String password)
    {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shop where username=?and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        boolean result = userDao.isExists("qwe", "123123");
        System.out.println(result);
    }
}
