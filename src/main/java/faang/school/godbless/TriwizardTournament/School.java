package faang.school.godbless.TriwizardTournament;

import java.util.List;

public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public List<Student> getTeam() {
        return team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}