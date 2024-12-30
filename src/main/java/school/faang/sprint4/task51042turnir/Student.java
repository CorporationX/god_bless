package school.faang.sprint4.task51042turnir;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer year;
    private Integer points;

    public void addPoints(Integer points) {
        this.points += points;
    }
}

