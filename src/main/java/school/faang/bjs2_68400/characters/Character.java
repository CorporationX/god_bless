package school.faang.bjs2_68400.characters;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new ArithmeticException(String.format("Значение здоровья персонажа %s " +
                    "не может быть отрицательным", name));
        }
        this.health = health;
    }

    protected Character(String name) {
        this.setName(name);
        this.setStrength(5);
        this.setAgility(5);
        this.setIntelligence(5);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.setName(name);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
    }

    public abstract void attack(Character opponent);

}
