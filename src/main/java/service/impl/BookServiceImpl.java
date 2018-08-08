package service.impl;

import dao.GenericDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.BookService;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, Integer> implements BookService {
    //    值的实例化  自动装配
    @Override
    @Autowired
    @Qualifier("bookDaoImpl")  //适配是那一个对象
    void setGenericDao(GenericDao<Book, Integer> genericDao) {
        super.genericDao = genericDao;
    }




}
