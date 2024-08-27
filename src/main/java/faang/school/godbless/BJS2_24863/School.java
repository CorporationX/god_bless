package faang.school.godbless.BJS2_24863;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class School {

    private final String name;

    private final List<Student> team = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addStudent(Student student) {
        team.add(student);
    }
}
