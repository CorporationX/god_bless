package faang.school.godbless.mt.tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class School {
    private String name;
    private final List<Student> students;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = new ArrayList<>(students);
    }

    public int getTotalPoints() {
        return students.stream().map(Student::getPoints).reduce(0, Integer::sum);
    }
}
