package taskAbstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - DEFAULT_STRENGTH);
    }
}
