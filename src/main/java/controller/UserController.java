package controller;

import model.Book;
import model.DownData;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.BookService;
import service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * ������
 * ע�ⷽʽ��д
 * ����ӳ��
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {//�߼�ҵ����

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
   /* @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;*/
/*
    @Autowired
    private SqlSession sqlSession;*/
   private static final String AVATAR_PATH = "/avatars";

    @RequestMapping("signUp")
    @ResponseBody
    private DownData signUp(User user) throws IOException {

        if (!userService.signUp(user)) {
            DownData data=new DownData("1","ע�����Ѿ�����!","false","");
            return data;
        }
//        userService.create(user);
        DownData data=new DownData("1","ע��ɹ�!","true",user);
        return data;
    }


    //�û��ĵ�¼
    @RequestMapping("signIn")
    @ResponseBody
    private DownData signIn(User user) {
       user=userService.singIn(user);
       if (user!=null){
//           session.setAttribute("user",user);
           List<Book> books=bookService.queryAll();
           user.setBooks(books);
           DownData data=new DownData("1","��¼�ɹ�!","true",user);
           return data;
       }
        DownData data=new DownData("1","��¼ʧ��!","false","");
        return data;
    }

//    ���������session�Ĺ���
    @RequestMapping("signOut")
    private String signOut() {
        session.invalidate();
        return "redirect:/index.jsp";
    }

//    ������е��û� id����
    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
        DownData data=new DownData("1","��ѯ�ɹ�!","true",userService.queryAll());
        return data;
    }

//    ȫ���û��Լ����µ�ͼ��
    @RequestMapping("queryAllUsers")
    @ResponseBody
    private DownData queryAllUsers() {
        DownData data=new DownData("1","��ѯ�ɹ�!","true",userService.queryList("queryAllUsers", null));
        return data;
    }

//     �����û���ѯ����������
    @RequestMapping("queryBooksByUserId/{id}")
    @ResponseBody
    private DownData queryBooksByUserId(@PathVariable int id) {
        DownData data=new DownData("1","��ѯ�ɹ�!","true",userService.queryOne("userQueryBooksByUserId", id));
//        System.out.println(userService.queryOne("userQueryBooksByUserId", id).toString());
        return data;
    }

//    ��������û� ȥ�����û���Ӧ�ĵ�ַ
    @RequestMapping("toCreateAddress")
    private String toCreateAddress() {
        session.setAttribute("users", userService.queryAll());
        return "redirect:/createAddress.jsp";
    }

    //    ���ָ���û� �Լ��û���Ӧ�ĵ�ַ
    @RequestMapping("userAddress/{id}")
    @ResponseBody
    private DownData userAddress(@PathVariable int id) {
        DownData data=new DownData("1","��ѯ�ɹ�!","true",userService.queryOne("userAddress", id));
        return data;
    }
}
