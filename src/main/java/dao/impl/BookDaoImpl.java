package dao.impl;

import dao.BookDao;
import model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book,Integer> implements BookDao {
/*
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<Book> queryAll() {
        return sqlSession.selectList("book.queryAll");
    }

    @Override
    public void create(Book book) {
        sqlSession.insert("book.create", book);
    }


    @Override
    public Book queryById(int id) {
        return sqlSession.selectOne("book.queryById", id);
    }

    @Override
    public void update(Book book) {
        sqlSession.update("book.update", book);
    }

    @Override
    public void remove(int id) {
        sqlSession.delete("book.remove", id);
    }

    @Override
    public void removeBooks(int[] ids) {
        for (int id : ids) {
            remove(id);
        }
    }*/
}
