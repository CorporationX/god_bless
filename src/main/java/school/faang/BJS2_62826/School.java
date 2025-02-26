package school.faang.BJS2_62826;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private final String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void changePointToStudents(int point) {
        students.forEach(student -> {
            student.setPoints(point);
        });
    }
}
