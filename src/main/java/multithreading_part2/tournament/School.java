package multithreading_part2.tournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public int getTotalPoints() {
        return students.stream()
                .map(student -> student.getPoints())
                .reduce(0, (x1, x2) -> x1 + x2);
    }
}
