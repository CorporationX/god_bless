package school.faang.bjs282831;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    @Setter
    private int points;

    public void addPoints(int additionalPoints) {
        this.points += additionalPoints;
    }
}
