package school.faang.sprint_4.task_51178;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }

    public void updatePoints(int points) {
        team.forEach(student -> student.addPoints(points));
    }
}
