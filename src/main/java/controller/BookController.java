package controller;

import model.Book;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

import java.util.Arrays;

/**
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
   /* @Autowired
    private SqlSession sqlSession;*/

//    @Qualifier("bookDaoImpl")  用那一个版本
    //     @Qualifier("JDBCBookDaoImpl")
/*@Autowired
    private BookDao bookDao;*/
    @Autowired
    private BookService bookService;

    @RequestMapping("create")
    private String create(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.insert("book.create", book);
//        }
        bookService.create(book);
        // return "redirect:/home.jsp";
            return queryAll();
        //      return queryById(4);
    }

    @RequestMapping("queryAll")
    private String queryAll() {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            session.setAttribute("books", sqlSession.selectList("book.queryAll"));
//        }
        User user= (User) session.getAttribute("user");
       session.setAttribute("books",bookService.queryList("queryBooksByUserId",user.getId()));
//         session.setAttribute("books",bookService.queryAll());
        return "redirect:/home.jsp";
    }

    @RequestMapping("queryById/{id}") //路径参数发设置和获取
    private String queryById(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
//            session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
//        }
        session.setAttribute("book", bookService.queryById(id));
        return "redirect:/edit.jsp";
    }

    @RequestMapping("update") //路径参数
    private String update(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.update("book.update", book);
//        }
        bookService.update(book);
        return queryAll();
    }

    @RequestMapping("remove/{id}") //路径参数
    private String remove(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.delete("book.remove", id);
//        }
        bookService.remove(id);
        return queryAll();
    }


    @RequestMapping("removeBooks") //路径参数removeBooks
    private String removeBooks(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            for (int id : ids) {
//                sqlSession.delete("book.remove", id);
//            }
//        }
//        bookDao.removeBooks(ids);
        bookService.removeSelected(ids);
        return queryAll();
    }

    @RequestMapping("queryAllBooks")
    private String queryAllbooks() {
        session.setAttribute("books", bookService.queryAll());
        return "redirect:/books.jsp";
    }

    @RequestMapping("queryUserByBookId/{id}")
    private String queryUserByBookId(@PathVariable int id) {
        session.setAttribute("book", bookService.queryOne("queryUserByBookId", id));
        return "redirect:/book.jsp";
    }
}
