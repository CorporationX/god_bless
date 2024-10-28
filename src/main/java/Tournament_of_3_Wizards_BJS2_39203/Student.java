package Tournament_of_3_Wizards_BJS2_39203;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints (int points) {
        this.points += points;
    }
}