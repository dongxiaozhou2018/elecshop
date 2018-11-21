package com.neuedu.dao;

import com.neuedu.DBUtils.DBUtils;

import java.sql.*;

public class UserDao {



    //判断用户名是否存在
    public  boolean isExists(String username,String password)
    {
        Connection connection = DBUtils.getConnection();
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
        boolean result = userDao.isExists("zhouhongyu", "123123");
        System.out.println(result);
    }
}
