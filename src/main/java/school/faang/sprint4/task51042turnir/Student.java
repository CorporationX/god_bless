package school.faang.sprint4.task51042turnir;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer year;
    private volatile Integer points;

    public synchronized void addPoints(Integer points) {
        this.points += points;
    }
}

