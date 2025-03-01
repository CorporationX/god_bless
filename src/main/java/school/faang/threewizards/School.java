package school.faang.threewizards;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private String school;
    private final List<Student> team;

    public School(String school, List<Student> team) {
        this.school = school;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, (Integer::sum));
    }
}
