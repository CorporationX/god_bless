package school.faang.MageTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public void addStudent(Student student) {
        team.add(student);
    }

    public int getTotalPoints(){
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
