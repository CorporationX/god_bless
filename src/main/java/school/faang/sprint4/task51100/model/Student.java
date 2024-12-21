package school.faang.sprint4.task51100.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
@ToString
public class Student {
    private final String name;
    private final int year;
    private int points = 0;

    private final Object lock = new Object();
    public void addPoint(int points) {
        synchronized (lock) {
            this.points += points;
        }
    }
}
