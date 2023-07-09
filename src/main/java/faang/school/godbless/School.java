package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student student : team) {
            totalPoints += student.getPoints();
        }
        return totalPoints;
    }
}
