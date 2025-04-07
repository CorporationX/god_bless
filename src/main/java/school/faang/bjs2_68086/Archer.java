package school.faang.bjs2_68086;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.dexterity;
        System.out.printf("Hunter attacked and dealt %d damage to %s.\n", this.getStrength(), opponent.name);
        checkIfOpponentIsKilled(opponent);
    }
}
