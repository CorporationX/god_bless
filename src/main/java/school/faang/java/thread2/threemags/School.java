package school.faang.java.thread2.threemags;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public Integer getTotalPoints() {
        return team.stream().mapToInt(Student::points).sum();
    }
}