package faang.school.godbless.async.triwizard_tournament;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        return students
                .stream()
                .map(Student::getPoints)
                .reduce(0, Integer::sum);
    }
}
