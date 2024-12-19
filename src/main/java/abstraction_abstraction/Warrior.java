package abstraction_abstraction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Warrior extends Character {
    private static final int STRENGHT = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGHT, DEXTERITY, INTELLIGENCE);
    }

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);

    }

    @Override
    public void attack(Character character) {
        if (character.health <= 0) {
            System.out.println(name + " погиб в бою");
        } else {
            character.health -= strength;
        }
    }
}
