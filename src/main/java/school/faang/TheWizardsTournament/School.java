package school.faang.TheWizardsTournament;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class School {
    private String name;
    private final List<Student> team = new ArrayList<>();

    public School(String name, List<Student> team) {
        this.name = name;
        this.team.addAll(team);
    }

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    public School earnPoints(int points) {
        int iterations = points / 10;
        int lastPoints = points % 10;

        for (int i = 0, j = 0; i < iterations; i++, j++) {

            if (i != iterations - 1) {
                team.get(j).setPoints(team.get(j).getPoints() + 10);
            } else {
                team.get(j).setPoints(team.get(j).getPoints() + lastPoints);
            }

            if (j == team.size() - 1) {
                j = -1;
            }
        }
        return this;
    }
}
