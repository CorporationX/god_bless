package faang.school.godbless.task.multithreading.async.three.magitian.tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private long point = 0;

    public void addPoint(long point) {
        this.point += point;
    }
}
