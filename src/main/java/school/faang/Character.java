package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Character {


    String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health;


    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100; // Устанавливаем здоровье по умолчанию
    }


    public Character(String name) {
        this.name = name;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0; // Здоровье не может быть отрицательным
        }
    }

    abstract public void attack(Character enemy);
}
