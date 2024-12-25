package school.faang.bjs251814;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }

}
