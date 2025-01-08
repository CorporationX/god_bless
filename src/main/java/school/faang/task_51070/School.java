package school.faang.task_51070;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students = new ArrayList<>();

    public long getTotalPoints() {
        return students.stream().mapToLong(Student::getPoints).sum();
    }
}
