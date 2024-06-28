package faang.school.godbless.HogwartsBattle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String year;
    private int points;

    public void addPonits(int points){
        this.points += points;
    }

}
