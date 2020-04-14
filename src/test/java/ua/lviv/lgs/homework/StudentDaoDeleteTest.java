package ua.lviv.lgs.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentDaoDeleteTest {
    private StudentDao studentDao;
    private Student student;

    @Before
    public void setup(){
        studentDao = new StudentDao();
        student = new Student(1, "test", 19);
    }

    @Test
    public void itStudentDeleting(){
        studentDao.create(student);

        studentDao.delete(1);
    }

    @Test(expected = RuntimeException.class)
    public void itStudentDeletingWithRuntimeException(){
        studentDao.delete(1);
    }

    @After
    public void afterTest(){
        studentDao = null;
        student = null;
    }
}
