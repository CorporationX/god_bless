package school.faang.bjs250591;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Superhero {

    private String name;
    private int strength;
    private int agility;

    public int getTotalPower() {
        return strength + agility;
    }

}
