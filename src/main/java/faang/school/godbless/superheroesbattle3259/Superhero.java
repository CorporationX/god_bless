package faang.school.godbless.superheroesbattle3259;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Superhero {
    private String name;
    @Setter private int strength;
    private int agility;
    private int totalPower;

    public Superhero(String name, int strength, int agility) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.totalPower = (int) (Math.ceil(strength * 1.477) + Math.ceil(agility * 2.322));
    }

    @Override
    public String toString() {
        return String.format("%s | str:%d | ag:%d",
                this.name,
                this.strength,
                this.agility);
    }
}
