package faang.school.godbless.asynchronism.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student student : team) {
            totalPoints = totalPoints + student.getPoints();
        }
        return totalPoints;
    }
}
