package service.impl;

import dao.GenericDao;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.CourseService;

@Service
public class CourseServiceImpl extends GenericServiceImpl<Course, Integer> implements CourseService {
    @Override
    @Autowired
    @Qualifier("courseDaoImpl")
    public void setGenericDao(GenericDao<Course, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}
