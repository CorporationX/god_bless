package faang.school.godbless.magicians;


import java.util.List;

public class School {
    private final String name;
    private List<Student> team;

    public String getName() {
        return name;
    }

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public List<Student> getTeam() {
        return team;
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
