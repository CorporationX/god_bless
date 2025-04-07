package school.faang.bjs2_68086;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {

    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.strength;
        System.out.printf("Warrior attacked and dealt %d damage to %s.\n", this.getStrength(), opponent.name);
        checkIfOpponentIsKilled(opponent);
    }
}
