package faang.school.godbless.BJS214408;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class School {

    private String name;
    private List<Student> team;

    public int getTotalPoints(){
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
