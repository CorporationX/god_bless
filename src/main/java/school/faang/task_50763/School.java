package school.faang.task_50763;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private final String name;
    private final List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public double getAverageMastery() {
        return team.stream()
                .mapToInt(Student::getMastery)
                .average()
                .orElse(0.0);
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(student -> student.getPoints().get())
                .sum();
    }

    public void addReward(Task task) {
        team.forEach(student -> student.addPoints(task.getReward()));
    }
}