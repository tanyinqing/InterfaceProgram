package dao.impl;

import dao.UserDao;
import model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

/*
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void create(User user) {
        sqlSession.insert("mapper.UserMapper.create", user);
    }

    @Override
    public User query(User user) {
        return  user = sqlSession.selectOne("mapper.UserMapper.signIn", user);
    }

    @Override
    public User queryByUsername(User user) {
        return sqlSession.selectOne("mapper.UserMapper.queryByUsername", user);
    }*/
}
