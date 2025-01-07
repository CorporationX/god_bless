package school.faang.task_51160;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
