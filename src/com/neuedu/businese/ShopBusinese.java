package com.neuedu.businese;

import com.neuedu.pojos.Shops;

import java.util.List;

public interface ShopBusinese {

    public Shops getOneShop(int shop_id);

    public void updateShop(Shops shop);
}
