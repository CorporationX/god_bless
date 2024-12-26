package school.faang.three_wizards;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void updateStudent(Student student) {
        if (team.stream().noneMatch(teammate -> student.getName().equals(teammate.getName()))) {
            throw new IllegalArgumentException("Student not found");
        }
        team = team.stream().map(teammate -> {
            if (teammate.getName().equals(student.getName())) {
                return student;
            } else {
                return teammate;
            }
        }).toList();
    }
}
