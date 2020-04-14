package ua.lviv.lgs.homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentDaoReadTest {
    private StudentDao studentDao;
    private Student student;

    @Before
    public void setup(){
        studentDao = new StudentDao();
        student = new Student(1, "test", 19);
    }

    @Test
    public void itStudentReading(){
        studentDao.create(student);

        Optional<Student> actual = studentDao.read(1);
        Student expected = student;

        Assert.assertEquals(expected, actual.get());
    }

    @Test
    public void itStudentReadingWithEmpty(){
        Optional<Student> actual = studentDao.read(2);

        Assert.assertEquals(Optional.empty(), actual);
    }

    @Test
    public void itStudentsReading(){
        studentDao.create(student);
        Student student2 = new Student(2, student.getName(), student.getAge());
        studentDao.create(student2);

        List<Student> actual = studentDao.readAll();
        List<Student> expected = Arrays.asList(student, student2);

        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterTest(){
        studentDao = null;
        student = null;
    }
}
