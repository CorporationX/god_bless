package faang.school.godbless.sprint4.wizard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class School {
    @Getter
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void modifyPoints(Task task) {
        team.forEach(s -> s.setPoints(s.getPoints() + task.reward()));
    }
}
