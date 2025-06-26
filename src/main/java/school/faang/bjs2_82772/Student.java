package school.faang.bjs2_82772;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void gainPoints(int amount) {
        points += amount;
    }
}
