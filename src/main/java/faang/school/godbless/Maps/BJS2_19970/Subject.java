package faang.school.godbless.Maps.BJS2_19970;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ToString
@Getter
@EqualsAndHashCode
public class Subject {
    private final int id;
    private String name;
    @EqualsAndHashCode.Exclude
    private List<Student> students = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
        id = ThreadLocalRandom.current().nextInt(1, 10000);
    }

    public List<Student> addStudent(Student student) {
        students.add(student);
        return students;
    }

    public List<Student> addStudent(List<Student> studentList) {
        students.addAll(studentList);
        return students;
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student.getId() + " : " + student.getName());
        }
    }
}
