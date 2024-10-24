package school.faang.magicaltournament;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class School {
    private String name;
    private List<Student> Team;

    public int getTotalPoints() {
        int sum = Team.stream().mapToInt(student -> student.getPoints()).reduce(0, Integer::sum);
        return sum;
    }

    public List<Student> getTeam() {
        return Team;
    }

    public String getName() {
        return name;
    }
}
