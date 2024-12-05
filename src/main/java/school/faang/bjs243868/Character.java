package school.faang.bjs243868;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Character {

    private String name;
    @Getter
    private Double power;
    @Getter
    private Double agility;
    private Double intellect;
    @Getter
    @Setter
    private Double health = 100D;

    public Character(String name) {
        this.name = name;
        this.power = 0D;
        this.agility = 0D;
        this.intellect = 0D;
    }

    public Character(String name, Double power, Double agility, Double intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character target);

}
