package faang.school.godbless.BJS2_6056;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        int result = 0;
        for (Student student : team) {
            result += student.getPoints();
        }
        return result;
    }
}
