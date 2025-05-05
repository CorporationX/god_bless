package school.faang.bjs2_74964;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int points) {
        if (points > 0) {
            log.info("Student {} got {} points", name, points);
        }
        this.points += points;
    }
}