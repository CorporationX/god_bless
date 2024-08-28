package faang.school.godbless.BJS2_24893;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public void addStudent(Student student) {
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
