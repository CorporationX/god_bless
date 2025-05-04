package school.faang.tournamentwizards;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
