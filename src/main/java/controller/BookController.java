package controller;

import model.Book;
import model.Course;
import model.DownData;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BookService;

import java.util.Arrays;
import java.util.List;

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
    @ResponseBody
    private DownData create(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.insert("book.create", book);
//        }
//        System.out.println(book.toString());
        bookService.create(book);
        // return "redirect:/home.jsp";
       /* String msg="图书创建成功";
        DownData data=new DownData("1",msg,"true","");
            return data;*/
            return queryAll();
        //      return queryById(4);
    }

    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            session.setAttribute("books", sqlSession.selectList("book.queryAll"));
//        }

        String msg="查询学生名下的全部图书";
        List<Book> addresses=bookService.queryList("queryBooksByUserId",1);
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }

    @RequestMapping("queryById/{id}") //路径参数发设置和获取
    @ResponseBody
    private DownData queryById(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
//            session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
//        }
        String msg="根据图书的id查询图书";
       Book addresses=bookService.queryById(id);
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }

    @RequestMapping("update") //路径参数
    @ResponseBody
    private DownData update(Book book) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.update("book.update", book);
//        }
        bookService.update(book);
        return queryAll();
    }

    @RequestMapping("remove/{id}") //路径参数
    @ResponseBody
    private DownData remove(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //运用mybatis框架把用户存储到数据库中  隐含的对应关系  false 查询和事务无关
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.delete("book.remove", id);
//        }
        bookService.remove(id);
        return queryAll();
    }


    //删除多本图书  它的参数是一个整形数组
    @RequestMapping("removeBooks") //路径参数removeBooks
    @ResponseBody
    private DownData removeBooks(Integer[] ids) {
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
    @ResponseBody
    private DownData queryAllbooks() {
        session.setAttribute("books", bookService.queryAll());
        String msg="查询全部图书";
        List<Book> addresses=bookService.queryAll();
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }

    @RequestMapping("queryUserByBookId/{id}")
    @ResponseBody
    private DownData queryUserByBookId(@PathVariable int id) {
        String msg="查询读过某本书的全部学生";
        Book addresses=bookService.queryOne("queryUserByBookId", id);
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }
}
