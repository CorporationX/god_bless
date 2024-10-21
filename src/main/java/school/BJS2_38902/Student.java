package school.BJS2_38902;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Student {

    private String name;
    private int year;
    @Setter
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }

}
