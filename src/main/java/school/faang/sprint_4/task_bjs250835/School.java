package school.faang.sprint_4.task_bjs250835;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class School {
    @NonNull
    @Getter
    private final String name;
    private final List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public synchronized void updateStudentPoints(int addedPoints) {
        students.forEach(student -> student.addPoints(addedPoints));
    }

}
