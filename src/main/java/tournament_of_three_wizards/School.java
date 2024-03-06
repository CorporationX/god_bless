package tournament_of_three_wizards;

import java.util.List;

class School {
    private final String name;
    private final List<Student> team;

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
