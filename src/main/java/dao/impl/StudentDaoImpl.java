package dao.impl;


import dao.StudentDao;
import model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentDao {
}
