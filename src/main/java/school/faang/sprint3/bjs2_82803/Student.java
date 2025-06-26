package school.faang.sprint3.bjs2_82803;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private Integer points;
    private final Object lock = new Object();

    public void changePoints(int change) {
        synchronized (lock) {
            points += change;
        }
    }
}
