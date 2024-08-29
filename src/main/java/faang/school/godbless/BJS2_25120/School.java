package faang.school.godbless.BJS2_25120;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class School {
    private final String name;
    private final List<Student> team;

    public School(String name) {
        this.name = name;
        this.team = new ArrayList<>();
    }


    public void addStudent(Student student) {
        team.add(student);
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

}
