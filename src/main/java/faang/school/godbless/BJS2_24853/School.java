package faang.school.godbless.BJS2_24853;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream().mapToInt(Student::getPoints).sum();
    }
}
