package faang.school.godbless.schoolTournament;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team = new LinkedList<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudentToSchoolTeam(Student student) {
        team.add(student);
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
