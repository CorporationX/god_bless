package faang.school.godbless.task3;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
abstract public class Character {
    private String name;
    private double force;
    private double agility;
    private double intelligence;
    private double health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, double force, double agility, double intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character deffer);

    public void attack(Character deffer, double damage) {
        double hp = deffer.getHealth();
        if (damage >= hp) {
            deffer.setHealth(0);
            System.out.println("+Kill");
        } else {
            deffer.setHealth(hp - damage);
        }
    }
}
