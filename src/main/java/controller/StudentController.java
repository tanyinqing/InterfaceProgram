package controller;

import model.DownData;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
        DownData data=new DownData("1","查询成功!","true",studentService.queryAll());
        return data;
    }


    @RequestMapping("studentCourses/{id}")
    @ResponseBody
    private DownData studentCourses(@PathVariable int id) {
        DownData data=new DownData("1","查询成功!","true",studentService.queryOne("studentCourses", id));
        return data;
    }

}
