package school.faang.task_50727;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class School {
    public String name;
    public List<Student> team;

    public int getTotalPoints() {
        AtomicInteger totalPoint = new AtomicInteger();
        team.stream()
                .forEach((student) -> totalPoint.addAndGet(student.getPoints()));
        return totalPoint.get();
    }
}
