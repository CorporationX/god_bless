package school.faang.task_50861;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Student {

    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        if (points <= 0) {
            log.info("Points can't be less than 0");
        }
        this.points += points;
    }
}