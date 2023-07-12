package faang.school.godbless.TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
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
