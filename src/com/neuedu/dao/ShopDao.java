package com.neuedu.dao;

import com.neuedu.pojos.Shops;

import java.sql.SQLException;
import java.util.List;

public interface ShopDao {

    public List<Shops> getAllShop();

    public  void deleteOneShop(int shop_id);

}
