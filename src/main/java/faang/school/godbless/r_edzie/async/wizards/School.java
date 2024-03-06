package faang.school.godbless.r_edzie.async.wizards;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class School {
    private String name;
    private List<Student> team = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return this.team.stream().map(Student::getPoints).reduce(Integer::sum).orElse(0);
    }

    public void addStudent(Student student) {
        team.add(student);
    }
}
