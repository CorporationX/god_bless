package faang.school.godbless.wizard_tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class School {
    private String name;
    private List<Student> team;

    public School(String name) {
        this.name = name;
        this.team = new ArrayList<>();
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addStudent(Student student) {
        team.add(student);
    }
}
