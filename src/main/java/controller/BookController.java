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
 * ������
 * ע�ⷽʽ��д
 * ����ӳ��
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {
   /* @Autowired
    private SqlSession sqlSession;*/

//    @Qualifier("bookDaoImpl")  ����һ���汾
    //     @Qualifier("JDBCBookDaoImpl")
/*@Autowired
    private BookDao bookDao;*/
    @Autowired
    private BookService bookService;

    @RequestMapping("create")
    @ResponseBody
    private DownData create(Book book) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.insert("book.create", book);
//        }
//        System.out.println(book.toString());
        bookService.create(book);
        // return "redirect:/home.jsp";
       /* String msg="ͼ�鴴���ɹ�";
        DownData data=new DownData("1",msg,"true","");
            return data;*/
            return queryAll();
        //      return queryById(4);
    }

    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            session.setAttribute("books", sqlSession.selectList("book.queryAll"));
//        }

        String msg="��ѯѧ�����µ�ȫ��ͼ��";
        List<Book> addresses=bookService.queryList("queryBooksByUserId",1);
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }

    @RequestMapping("queryById/{id}") //·�����������úͻ�ȡ
    @ResponseBody
    private DownData queryById(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
//            session.setAttribute("book", sqlSession.selectOne("book.queryById", id));
//        }
        String msg="����ͼ���id��ѯͼ��";
       Book addresses=bookService.queryById(id);
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }

    @RequestMapping("update") //·������
    @ResponseBody
    private DownData update(Book book) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.update("book.update", book);
//        }
        bookService.update(book);
        return queryAll();
    }

    @RequestMapping("remove/{id}") //·������
    @ResponseBody
    private DownData remove(@PathVariable int id) {
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
//        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
//            sqlSession.delete("book.remove", id);
//        }
        bookService.remove(id);
        return queryAll();
    }


    //ɾ���౾ͼ��  ���Ĳ�����һ����������
    @RequestMapping("removeBooks") //·������removeBooks
    @ResponseBody
    private DownData removeBooks(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
//        System.out.println("user..."+user.toString());
        //����mybatis��ܰ��û��洢�����ݿ���  �����Ķ�Ӧ��ϵ  false ��ѯ�������޹�
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
        String msg="��ѯȫ��ͼ��";
        List<Book> addresses=bookService.queryAll();
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }

    @RequestMapping("queryUserByBookId/{id}")
    @ResponseBody
    private DownData queryUserByBookId(@PathVariable int id) {
        String msg="��ѯ����ĳ�����ȫ��ѧ��";
        Book addresses=bookService.queryOne("queryUserByBookId", id);
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }
}
