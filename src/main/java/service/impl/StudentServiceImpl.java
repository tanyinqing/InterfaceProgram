package service.impl;

import dao.GenericDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.StudentService;

@Service
public class StudentServiceImpl extends GenericServiceImpl<Student, Integer> implements StudentService {
    @Override
    @Autowired
    @Qualifier("studentDaoImpl")
    public void setGenericDao(GenericDao<Student, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}
