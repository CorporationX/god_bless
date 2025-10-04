package school.faang.m1.future.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class School {

    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(student -> student.getPoints().get()).sum();
    }
}

