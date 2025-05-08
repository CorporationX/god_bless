package school.faang.potter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class School {
    private final String name;
    private final List<Student> team;

    public void addPointsToAll(int points) {
        team.forEach(student -> student.addPoints(points / team.size()));
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}