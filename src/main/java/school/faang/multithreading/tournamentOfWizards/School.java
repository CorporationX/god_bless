package school.faang.multithreading.tournamentOfWizards;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }

    public void awardPointsToAllStudents(Task task) {
        students.forEach(student -> student.addPoints(task.getReward()));
    }
}
