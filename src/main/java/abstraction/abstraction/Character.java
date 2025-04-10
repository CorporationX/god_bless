package abstraction.abstraction;

import lombok.Getter;

public abstract class Character {
    @Getter
    private String name;
    @Getter
    private int power;
    @Getter
    private int agility;
    private int intellect;
    @Getter
    private int health = CharacterConfiguration.getDefaultHealt();

    public Character(String name) {
        this(name, CharacterConfiguration.getDefaultCharacterPower(),
                CharacterConfiguration.getDefaultCharacterAgility(),
                CharacterConfiguration.getDefaultCharacterIntellect());
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected abstract void attack(Character opponent);

    protected boolean checkOpponentHealth(int oponnentHealth, int damage) {
        if (oponnentHealth < damage) {
            return false;
        }
        return true;
    }

    protected void setDamage(int damage) {
        if (checkOpponentHealth(this.health, damage)) {
            this.health -= damage;
        }
        this.health = 0;
    }
}
