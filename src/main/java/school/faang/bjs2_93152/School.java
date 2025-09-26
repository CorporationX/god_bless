package school.faang.bjs2_93152;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToAll(int points) {
        team.forEach(student -> student.addPoints(points));
    }

    @Override
    public String toString() {
        return name + " [Total: " + getTotalPoints() + "]";
    }
}