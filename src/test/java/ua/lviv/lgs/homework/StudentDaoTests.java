package ua.lviv.lgs.homework;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({StudentDaoCreateTest.class, StudentDaoReadTest.class, StudentDaoUpdateTest.class, StudentDaoDeleteTest.class})
public class StudentDaoTests {

}
