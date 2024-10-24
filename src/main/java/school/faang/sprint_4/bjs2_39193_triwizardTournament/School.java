package school.faang.sprint_4.bjs2_39193_triwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class School {
    private final List<Student> team = new ArrayList<>();
    @Getter
    private final double averageMastery;
    @Getter
    private String name;

    public School(String name, List<Student> students) {
        this.name = name;
        team.addAll(students);
        averageMastery = students.stream()
                .map(Student::getMastery)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public Integer getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void addReward(Task task) {
        team.forEach(student -> student.addPoints(task.getReward()));
    }
}
