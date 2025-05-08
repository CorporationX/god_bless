package school.faang.bjs2_75778;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public synchronized int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
