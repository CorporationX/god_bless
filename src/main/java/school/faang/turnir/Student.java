package school.faang.turnir;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

    String name;
    Integer year;
    Integer points;

    public void updatePoints(Integer addPoints) {
        this.points += addPoints;
    }
}
