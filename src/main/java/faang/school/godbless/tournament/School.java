package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;
    public Integer getTotalPoints(){
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
