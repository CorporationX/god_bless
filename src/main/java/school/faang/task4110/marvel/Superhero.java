package school.faang.task4110.marvel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Superhero {
    private String name;
    private int strength;
    private int agility;

    public Superhero fight(Superhero superhero) {
        int thisHeroPower = agility + strength;
        int enemyPower = superhero.getAgility() + superhero.getStrength();
        return thisHeroPower >= enemyPower ? this : superhero;
    }
}
