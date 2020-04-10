package ua.lviv.lgs.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements CRUD<Student> {
    private List<Student> students = new ArrayList<>();

    @Override
    public Student create(Student student) {
        boolean result = students.stream()
                .map(Student::getId)
                .anyMatch(id -> id == student.getId());

        if (!result){
            students.add(student);
        } else {
            throw new RuntimeException("Student with that id already exists!");
        }

        return student;
    }

    @Override
    public Student read(int id) {
        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        return student;
    }

    @Override
    public List<Student> readAll() {
        return students;
    }

    @Override
    public void update(int id, Student student) {
        Student read = read(id);

        if (read == null){
            throw new RuntimeException("Student with such id not found!");
        }

        students.removeIf(s -> s.getId() == id);
        students.add(student);
    }

    @Override
    public void delete(int id) {
        Student read = read(id);

        if (read == null){
            throw new RuntimeException("Student with such id not found!");
        }

        students.removeIf(s -> s.getId() == id);
    }
}
