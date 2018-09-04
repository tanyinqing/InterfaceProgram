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
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {//高级业务类

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
            DownData data=new DownData("1","注册名已经存在!","false","");
            return data;
        }
//        userService.create(user);
        DownData data=new DownData("1","注册成功!","true",user);
        return data;
    }


    //用户的登录
    @RequestMapping("signIn")
    @ResponseBody
    private DownData signIn(User user) {
       user=userService.singIn(user);
       if (user!=null){
//           session.setAttribute("user",user);
           List<Book> books=bookService.queryAll();
           user.setBooks(books);
           DownData data=new DownData("1","登录成功!","true",user);
           return data;
       }
        DownData data=new DownData("1","登录失败!","false","");
        return data;
    }

//    这个是销毁session的过程
    @RequestMapping("signOut")
    private String signOut() {
        session.invalidate();
        return "redirect:/index.jsp";
    }

//    查出所有的用户 id降序
    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
        DownData data=new DownData("1","查询成功!","true",userService.queryAll());
        return data;
    }

//    全部用户以及名下的图书
    @RequestMapping("queryAllUsers")
    @ResponseBody
    private DownData queryAllUsers() {
        DownData data=new DownData("1","查询成功!","true",userService.queryList("queryAllUsers", null));
        return data;
    }

//     根据用户查询它所读的书
    @RequestMapping("queryBooksByUserId/{id}")
    @ResponseBody
    private DownData queryBooksByUserId(@PathVariable int id) {
        DownData data=new DownData("1","查询成功!","true",userService.queryOne("userQueryBooksByUserId", id));
//        System.out.println(userService.queryOne("userQueryBooksByUserId", id).toString());
        return data;
    }

//    查出所有用户 去创建用户对应的地址
    @RequestMapping("toCreateAddress")
    private String toCreateAddress() {
        session.setAttribute("users", userService.queryAll());
        return "redirect:/createAddress.jsp";
    }

    //    查出指定用户 以及用户对应的地址
    @RequestMapping("userAddress/{id}")
    @ResponseBody
    private DownData userAddress(@PathVariable int id) {
        DownData data=new DownData("1","查询成功!","true",userService.queryOne("userAddress", id));
        return data;
    }
}
