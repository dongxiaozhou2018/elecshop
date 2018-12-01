package com.neuedu.businese;

import com.neuedu.DBUtils.DBUtils;
import com.neuedu.dao.ShopDao;
import com.neuedu.dao.ShopDaoImpl;
import com.neuedu.pojos.Shops;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopBusineseImpl implements ShopBusinese {

    private ShopDao shopDao = new ShopDaoImpl();
    @Override
    public Shops getOneShop(int shop_id) {
        return shopDao.getOneShop(shop_id);
    }

    @Override
    public void updateShop(Shops shop) {
        shopDao.updateShop(shop);
    }
}
