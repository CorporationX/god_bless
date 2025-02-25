package school.faang.sprint4.bjs2_62329;

import lombok.NonNull;

import java.util.List;

public class School {
    private final String name;
    private final List<Student> team;

    public School(@NonNull String name, @NonNull List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
