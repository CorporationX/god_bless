package faang.school.godbless.BJS2_25075;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students = new ArrayList<>();

    public int getTotalPoints() {
        AtomicInteger totalPoints = new AtomicInteger(0);
        students.forEach(student -> totalPoints.addAndGet(student.getPoints()));

        return totalPoints.get();
    }
}
