package faang.school.godbless.superheros;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Superhero {
    private String name;
    private int strength;
    private int agility;

    public int getTotalPower() {
        return strength + agility;
    }
}
