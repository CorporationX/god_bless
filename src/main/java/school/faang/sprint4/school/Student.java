package school.faang.sprint4.school;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
public class Student {

    private final String name;
    private final Integer year;
    // правильно ли, при условии, что одному студенту может прийти несколько заданий?
    private final AtomicInteger points;

    public void addPoints(int points) {
        System.out.printf("%s add points to student %s\n", Thread.currentThread().getName(), name);
        this.points.addAndGet(points);
    }
}
