package abstraction.abstraction;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Getter
    private String name;
    @Getter
    private int power;
    @Getter
    private int agility;
    private int intellect;
    @Getter
    @Setter
    private int health = CharacterConfiguration.DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
        this.power = CharacterConfiguration.DEFAULT_CHARACTER_POWER;
        this.agility = CharacterConfiguration.DEFAULT_CHARACTER_AGILITY;
        this.intellect = CharacterConfiguration.DEFAULT_CHARACTER_INTELLECT;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected abstract void attack(Character opponent);

    protected boolean checkOpponentHealth(int oponnentHealth, int entityAtack) {
        if (oponnentHealth > 0 && oponnentHealth >= entityAtack) {
            return true;
        }
        return false;
    }
}
