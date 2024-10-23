package school.faang.tournament;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class School {

    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        Objects.requireNonNull(team, "Team list cannot be null");
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void setTeam(List<Student> team) {
        Objects.requireNonNull(team, "Team list cannot be null");
        this.team = team;
    }
}
