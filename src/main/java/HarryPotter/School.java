package HarryPotter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class School {
    private String name;
    private final List<Student> team = new ArrayList<>();

    public void addStudentToTeam(Student student) {
        team.add(student);
    }

    public School(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student student : team) {
            totalPoints += student.getPoints();
        }
        return totalPoints;
    }
}
