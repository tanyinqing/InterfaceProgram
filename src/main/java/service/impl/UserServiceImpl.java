package service.impl;

import dao.GenericDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {
    @Override
    @Autowired
    @Qualifier("userDaoImpl")
    void setGenericDao(GenericDao<User, Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public boolean signUp(User user) {
        if (super.genericDao.queryOne("queryByUsername", user.getUsername()) != null) {
            return false;
        }
        super.genericDao.create(user);
        return true;
    }

    @Override
    public User singIn(User user) {
        String plainPassword=user.getPassword();
        user=super.genericDao.queryOne("user.queryByUsername",user);
        if (user!=null&&DigestUtils.md5DigestAsHex(plainPassword.getBytes()).equals(user.getPassword())) {
            return user;
        }
        return null;
    }


}
