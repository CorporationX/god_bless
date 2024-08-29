package faang.school.godbless.bjs2_24947;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
