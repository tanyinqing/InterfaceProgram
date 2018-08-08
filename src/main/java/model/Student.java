package model;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    // 主键用封装类  比较大用 长整型
    private  Integer id;
    private  String name;
    private List<Course> courses;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
