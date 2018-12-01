package com.neuedu.dao;

import com.neuedu.pojos.Shops;

import java.util.List;

public interface ShopDao {

    public List<Shops> getAllShop();

    public  void deleteOneShop(int shop_id);

    public boolean addOneProduct(Shops shops);

    public Shops getOneShop(int shop_id);

    public void updateShop(Shops shop);

}