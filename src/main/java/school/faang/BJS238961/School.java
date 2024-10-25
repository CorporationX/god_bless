package school.faang.BJS238961;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        AtomicInteger total = new AtomicInteger();
        team.forEach(student -> total.getAndAdd(student.getPoints()));
        return total.get();
    }
}
