package com.neuedu.businese;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UsersDao;
import com.neuedu.dao.UsersDaoImpl;
import com.neuedu.pojos.User;

public class UserBusineseImpl implements UserBusinese {

    UsersDao userDao = new UsersDaoImpl();

    @Override
    public boolean userIsExist(User user) {

        return userDao.isExists(user);
    }
}
