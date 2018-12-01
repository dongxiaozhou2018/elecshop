package com.neuedu.dao;

import com.neuedu.DBUtils.DBUtils;
import com.neuedu.pojos.Shops;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements ShopDao {
    @Override
    public List<Shops> getAllShop() {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        List<Shops> lists = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from goods");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int shop_id = resultSet.getInt("shop_id");
                String shop_name = resultSet.getString("shop_name");
                String shop_img = resultSet.getString("shop_img");
                String shop_des = resultSet.getString("shop_des");
                BigDecimal shop_price = resultSet.getBigDecimal("shop_price");
                Shops shops = new Shops(shop_id,shop_name,shop_img,shop_des,shop_price);
                lists.add(shops);
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return lists;
    }

    @Override
    public void deleteOneShop(int shop_id)
    {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from goods where shop_id=?");
            preparedStatement.setInt(1,shop_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeResource(connection,preparedStatement,null);
        }
    }

    @Override
    public boolean addOneProduct(Shops shop) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("INSERT into goods(shop_name,shop_img,shop_des,shop_price) values (?,?,?,?)");
            preparedStatement.setString(1,shop.getShop_name());
            preparedStatement.setString(2,shop.getShop_img());
            preparedStatement.setString(3,shop.getShop_des());
            preparedStatement.setBigDecimal(4,shop.getShop_price());
            int i = preparedStatement.executeUpdate();
            if(i != 0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(connection,preparedStatement,null);
        }
        return false;
    }

    public Shops getOneShop(int shop_id)
    {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement("select * from goods where shop_id=?");
            preparedStatement.setInt(1,shop_id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int shop_id1 = resultSet.getInt("shop_id");
                String shop_name = resultSet.getString("shop_name");
                String shop_img = resultSet.getString("shop_img");
                String shop_des = resultSet.getString("shop_des");
                BigDecimal shop_price = resultSet.getBigDecimal("shop_price");
                Shops shops = new Shops(shop_id1,shop_name,shop_img,shop_des,shop_price);
                return shops;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Override
    public void updateShop(Shops shop) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE goods set shop_name=?,shop_img=?,shop_des=?,shop_price=? where shop_id=?");
            preparedStatement.setString(1,shop.getShop_name());
            preparedStatement.setString(2,shop.getShop_img());
            preparedStatement.setString(3,shop.getShop_des());
            preparedStatement.setBigDecimal(4,shop.getShop_price());
            preparedStatement.setInt(5,shop.getShop_id());
            int i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResource(connection,preparedStatement,null);
        }
    }
}