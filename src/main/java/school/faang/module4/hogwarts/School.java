package school.faang.module4.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@AllArgsConstructor
@Slf4j
public class School {
    private String name;
    private List<Student> team;

    public synchronized void receivePoints(int points) {
        if (team.isEmpty()) {
            log.info("team is empty");
            return;
        }

        int partOfPoints = points / team.size();
        team.forEach(student -> student.addPoints(partOfPoints));

        if (points - partOfPoints * team.size() > 0) {
            var student = team.get(0);
            student.addPoints(points - partOfPoints * team.size());
        }
    }

    public int getTotalPoints() {
        return team.stream().reduce(0, (points, student) -> points + student.getPoints(), Integer::sum);
    }
}
