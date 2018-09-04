package controller;

import model.Address;
import model.Course;
import model.DownData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CourseService;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController extends BaseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public DownData queryAll() {
        String msg="��ѯȫ���γ�";
        List<Course> addresses=courseService.queryAll();
        DownData data=new DownData("1",msg,"true",addresses);
        return data;
    }


    @RequestMapping("courseStudents/{id}")
    @ResponseBody
    private DownData courseStudents(@PathVariable int id) {
        String msg="ͨ�������ϲ�ѯ��ͨ��id�ҵ��γ�  �Լ�ͨ��ѧ���Ϳγ̱�Ķ�Ӧ��ϵ �ҵ�ѧϰ�ÿγ̵�ѧ��";
        Course course=courseService.queryOne("courseStudents", id);
        DownData data=new DownData("1",msg,"true",course);
        return data;
    }
}
