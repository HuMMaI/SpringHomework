package ua.lviv.lgs.homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDaoCreateTest {
    private StudentDao studentDao;
    private Student student;

    @Before
    public void setup(){
        studentDao = new StudentDao();
        student = new Student(1, "test", 19);
    }

    @Test
    public void itStudentCreating(){
        Student actual = studentDao.create(this.student);
        Student expected = student;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void itStudentCreatingWithRuntimeException(){
        studentDao.create(student);
        studentDao.create(student);
    }

    @Test(expected = NullPointerException.class)
    public void itStudentCreatingWithNullPointerException(){
        studentDao.create(null);
    }

    @After
    public void afterTest(){
        studentDao = null;
        student = null;
    }
}
