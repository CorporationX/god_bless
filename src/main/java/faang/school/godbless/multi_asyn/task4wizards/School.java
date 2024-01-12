package faang.school.godbless.multi_asyn.task4wizards;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints(){
        return team.stream()
                .map((Student::getPoints))
                .reduce(Integer::sum)
                .orElseThrow();
    }
}
