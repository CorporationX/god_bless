package tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Getter
@Setter
public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void updatePoints(int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
