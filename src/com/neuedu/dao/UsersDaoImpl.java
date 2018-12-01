package com.neuedu.dao;

import com.neuedu.DBUtils.DBUtils;
import com.neuedu.pojos.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements UsersDao {
    @Override
    public boolean addOneUser(User user) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert into shop(username,password,email,tel)values (?,?,?,?)");
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassWord());
            preparedStatement.setString(3,user.geteMail());
            preparedStatement.setString(4,user.getTel());
            int result = preparedStatement.executeUpdate();
            if(result != 0)
            {
                 return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            DBUtils.closeResource(connection,preparedStatement,null);
        }
        return false;
    }

    @Override
    public boolean isExists(User user) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select *from shop where username=?and password=?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResource(connection, preparedStatement, null);
        }
        return false;
    }
}
