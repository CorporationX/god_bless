package faang.school.godbless;

import lombok.Data;

@Data
public abstract class Character {
    String name;
    int Power;
    int lovkost;
    int intelekt;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int lovkost, int intelekt) {
        this.name = name;
        Power = power;
        this.lovkost = lovkost;
        this.intelekt = intelekt;
    }
    abstract void attack(Character character);
}
