package school.faang.magicians;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class School {
    private final String name;
    private List<Student> students;

    public int getPoints() {
        return students.stream().map(Student::getPoints).filter(Objects::nonNull).mapToInt(AtomicInteger::get).sum();
    }

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}
