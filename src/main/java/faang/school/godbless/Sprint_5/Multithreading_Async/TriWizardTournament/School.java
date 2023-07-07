package faang.school.godbless.Sprint_5.Multithreading_Async.TriWizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().map(stud -> stud.getPoints()).collect(Collectors.summingInt(Integer::intValue));
    }
}
