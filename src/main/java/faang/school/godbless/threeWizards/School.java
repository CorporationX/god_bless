package faang.school.godbless.threeWizards;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints(){
        return team.stream()
                .map(Student::getPoints)
                .reduce(0, (Integer::sum));
    }
}
