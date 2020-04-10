package ua.lviv.lgs.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HomeworkApplication.class, args);
		StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");

		Student student1 = new Student(1, "Student1", 19);
		Student student2 = new Student(2, "Student2", 20);
		Student student3 = new Student(3, "Student3", 18);
		Student student4 = new Student(4, "Student4", 17);
		Student student5 = new Student(5, "Student5", 22);

		studentDao.create(student1);
		studentDao.create(student2);
		studentDao.create(student3);
		studentDao.create(student4);
		studentDao.create(student5);

		System.out.println("=========================================================");
		Student read = studentDao.read(3);
		System.out.println(read);
		System.out.println("=========================================================");

		System.out.println("=========================================================");
		List<Student> students = studentDao.readAll();
		System.out.println(students);
		System.out.println("=========================================================");

		System.out.println("=========================================================");
		Student student6 = new Student(1, "Student6", 21);
		studentDao.update(1, student6);
		Student read2 = studentDao.read(1);
		System.out.println(read2);
		System.out.println("=========================================================");

		System.out.println("=========================================================");
		studentDao.delete(3);
		List<Student> students2 = studentDao.readAll();
		System.out.println(students2);
		System.out.println("=========================================================");
	}

}
