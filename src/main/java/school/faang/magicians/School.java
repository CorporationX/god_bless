package school.faang.magicians;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private final String name;
    private List<Student> students;

    public int getPoints() {
        return students.stream().mapToInt(student -> student.getPoints().get()).sum();
    }

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}
