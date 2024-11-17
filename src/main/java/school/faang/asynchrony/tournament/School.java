package school.faang.asynchrony.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class School {
    private String name;
    private List<Student> team;

    public Integer getTotalPoints() {
        Integer totalPoints = 0;
        for (Student student : team) {
            totalPoints += student.getPoints();
        }
        return totalPoints;
    }
}
