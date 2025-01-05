package school.faang.bjs51023;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private String name;
    private final List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
