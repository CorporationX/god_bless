package faang.school.godbless.BJS2_25050;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private String name;
    private List<Student> students;
    private int teamPoints;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
        this.teamPoints = students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void addPoints(int points) {
        teamPoints += points;
    }
}
