package school.faang.task_50793;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }

    public void increasePointsForEveryStudent(int reward) {
        team.forEach(s -> s.setPoints(reward / team.size()));
    }
}
