package faang.school.godbless.BJS2_14365;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class School {
    private final String name;
    private List<Student> team;

    public School(String name) {
        this.name = name;
    }

    public void addStudentsToSchool(Student... students) {
        if (team == null) {
            team = new ArrayList<>();
        }
        team.addAll(Arrays.asList(students));
    }

    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).reduce(Integer::sum).get();
    }
}
