package school.faang.bjs251129;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Student {

    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            log.error("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (year <= 0) {
            log.error("Year must be a positive integer");
            throw new IllegalArgumentException("Year must be a positive integer");
        }
        this.name = name;
        this.year = year;
        this.points = 0;
        log.info("Student created: {} in year {}", name, year);
    }

    public void addPoint(int points) {
        this.points += points;

    }

}

