package faang.school.godbless.spring_4.triwizard_tournament;

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

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getTeam() {
        return team;
    }

    public void setTeam(List<Student> team) {
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).mapToInt(integer -> integer).sum();
    }
}
