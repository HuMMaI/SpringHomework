package ua.lviv.lgs.homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDaoUpdateTest {
    private StudentDao studentDao;
    private Student student;
    private Student student2;

    @Before
    public void setup(){
        studentDao = new StudentDao();
        student = new Student(1, "test", 19);
        student2 = new Student(1, "test2", 25);
    }

    @Test
    public void itStudentUpdating(){
        studentDao.create(student);

        studentDao.update(1, student2);

        Student actual = studentDao.read(1);
        Student expected = student2;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void itStudentUpdatingWithRuntimeException(){
        studentDao.update(1, student2);
    }

    @After
    public void afterTest(){
        studentDao = null;
        student = null;
        student2 = null;
    }
}
