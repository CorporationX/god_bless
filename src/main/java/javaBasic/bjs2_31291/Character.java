package javaBasic.bjs2_31291;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Character {
    private static final int LOW_HEALTH_THRESHOLD = 20; // Порог здоровья
    @Getter
    private int maxHealth = 100;
    private String name;
    @Getter
    private int strength;
    @Getter
    private int dexterity;
    private int intelligence;
    @Getter
    private int health;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = this.maxHealth;
    }

    public Character(String name) {
        this(name, 0, 0, 0);
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0; // Здоровье не может быть отрицательным
        }
        checkLowHealth();
    }

    protected abstract void activateAbility();

    public abstract void receiveDamage(int damage);

    private void checkLowHealth() {
        if (this.health <= this.maxHealth * LOW_HEALTH_THRESHOLD / 100) {
            activateAbility();
        }
    }

    public double getLowHealthThreshold() {
        return LOW_HEALTH_THRESHOLD / 100.0; // Возвращает порог как десятичное число
    }

    abstract public void attack(Character enemy);
}
