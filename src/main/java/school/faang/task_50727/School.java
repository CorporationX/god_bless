package school.faang.task_50727;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    public String name;
    public List<Student> team;

    public int getTotalPoints() {
        int totalPoint = 0;
        for (Student student : team) {
            totalPoint += student.getPoints();
        }
        return totalPoint;
    }
}
