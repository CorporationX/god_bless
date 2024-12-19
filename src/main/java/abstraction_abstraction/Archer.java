package abstraction_abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {
    private static final int STRENGHT = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGHT, DEXTERITY, INTELLIGENCE);
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        if (character.health > 0) {
            character.health -= dexterity;
        } else {
            System.out.println(name + " погиб в бою");
        }
    }
}
