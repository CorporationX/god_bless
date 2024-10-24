package school.faang.threewizards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPints(int points) {
        this.points += points;
    }
}
