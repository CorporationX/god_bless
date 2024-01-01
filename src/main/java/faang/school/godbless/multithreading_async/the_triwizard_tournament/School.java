package faang.school.godbless.multithreading_async.the_triwizard_tournament;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;


    public int getTotalPoints() {
        return team.stream().mapToInt(student -> student.getPoints()).sum();
    }

}
