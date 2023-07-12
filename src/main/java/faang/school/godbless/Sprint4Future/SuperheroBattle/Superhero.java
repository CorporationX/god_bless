package faang.school.godbless.Sprint4Future.SuperheroBattle;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Superhero {
    private String name;
    private int strength;
    private int agility;

    public int getPointsToWin(){
        return strength + agility;
    }
}
