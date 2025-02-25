package school.faang.sprint4.bjs2_62329;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
