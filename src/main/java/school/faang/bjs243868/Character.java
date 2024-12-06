package school.faang.bjs243868;

import lombok.Getter;
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

    public void receiveDamage(Double damage) {
        if (damage < 0) {
            throw new RuntimeException("Damage can not be negative");
        }
        this.health = Math.max(this.health - damage, 0D);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void attack(Character target);

}
