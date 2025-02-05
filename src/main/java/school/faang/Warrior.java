package school.faang;

import lombok.Data;


public class Warrior extends Character {
    public static final int DEFAULT_STRENGTH = 10;
    public static final  int DEFAULT_DEXTERITY = 5;
    public static final  int DEFAULT_INTELLIGENCE = 3;


    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
        this.strength = DEFAULT_STRENGTH;
        this.dexterity = DEFAULT_DEXTERITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }
}
