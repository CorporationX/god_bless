package Sprint_4.BJS2_38502;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Superhero {
    String name;
    int strength;
    int agility;

    public Superhero(String name, int strength, int agility) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
    }

    @Override
    public String toString() {
        return name + " (Сила: " + strength + ", Ловкость: " + agility + ")";
    }
}
