package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController extends BaseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("queryAll")
    public String queryAll() {
        session.setAttribute("courses", courseService.queryAll());
        return "redirect:/courses.jsp";
    }

    @RequestMapping("courseStudents/{id}")
    private String courseStudents(@PathVariable int id) {
        session.setAttribute("course", courseService.queryOne("courseStudents", id));
        return "redirect:/course.jsp";
    }
}
