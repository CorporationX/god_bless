package school.faang.task_50861;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
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