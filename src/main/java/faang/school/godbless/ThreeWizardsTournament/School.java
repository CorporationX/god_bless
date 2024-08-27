package faang.school.godbless.ThreeWizardsTournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class School {
    private String name;
    private List<Student> team;

    public School(String name) {
        this.name = name;
        team = new ArrayList<>();
    }

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).reduce(0, Integer::sum);
    }
}
