package ua.lviv.lgs.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao implements CRUD<Student> {
    private List<Student> students = new ArrayList<>();

    @Override
    public Student create(Student student) {
        Optional<Integer> result = students.stream()
                .map(Student::getId)
                .filter(id -> id == student.getId())
                .findAny();

        if (result.isPresent()){
            throw new RuntimeException("Student with that id already exists!");
        } else {
            students.add(student);
        }

        return student;
    }

    @Override
    public Optional<Student> read(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public List<Student> readAll() {
        return students;
    }

    @Override
    public void update(int id, Student student) {
        Optional<Student> read = read(id);

        if (!read.isPresent()){
            throw new RuntimeException("Student with such id not found!");
        }

        students.removeIf(s -> s.getId() == id);
        students.add(student);
    }

    @Override
    public void delete(int id) {
        Optional<Student> read = read(id);

        if (!read.isPresent()){
            throw new RuntimeException("Student with such id not found!");
        }

        students.removeIf(s -> s.getId() == id);
    }
}
