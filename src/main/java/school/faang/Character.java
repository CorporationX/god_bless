package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int iq;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.iq = 5;
    }

    public Character(String name, int dexterity, int strength, int iq) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.iq = iq;
    }


    public void HealthIsZero() {
        if(this.getHealth() == 0) {
            throw new IllegalArgumentException("Здоровье не может быть меньше 0");
        }
    }

    public abstract void attack(Character opponent);


}
