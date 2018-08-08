package dao.impl;


import dao.CourseDao;
import model.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseDao {
}
