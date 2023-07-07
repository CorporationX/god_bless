package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Data
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        AtomicInteger result = new AtomicInteger();

        team.forEach((student -> result.addAndGet(student.getPoints())));

        return result.get();
    }
}
