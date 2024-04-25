package faang.school.godbless.threemagetournament;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = initialize();
    }

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    private List<Student> initialize() {
        return List.of(
                new Student("qwe", 13, 0),
                new Student("qwe2", 13, 0),
                new Student("qwe3", 13, 0)
        );
    }
}
