package school.faang.bjs2_92878;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private final String name;
    private final List<Student> team;

    public void increaseSchoolPoints(int points) {
        for (Student student : team) {
            student.increasePoints(points);
        }
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
