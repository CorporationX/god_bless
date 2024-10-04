package school.faang.javaBasic.bjs2_31291;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Character {
    private static final int LOW_HEALTH_THRESHOLD = 20;
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

    public Character (String name) {
        this(name, 0, 0, 0);
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0; // Здоровье не может быть отрицательным
        }
        checkLowHealth();
    }
    private void activateAbility() {
        System.out.println(this.name + " активировал способность! Низкий уровень здоровья: " + this.health);
    }
    public void receiveDamage(int damage) {
        this.takeDamage(damage);
    }
    private void checkLowHealth() {
        if (this.health <= this.maxHealth * LOW_HEALTH_THRESHOLD / 100) {
            activateAbility();
        }
    }

    abstract public void attack(Character enemy);
}
