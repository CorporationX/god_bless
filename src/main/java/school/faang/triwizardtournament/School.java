package school.faang.triwizardtournament;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private final String name;
    private final List<Student> students;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public int getTotalPoints() {
        return students.stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
