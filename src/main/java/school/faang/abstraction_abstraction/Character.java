package school.faang.abstraction_abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private static final int MAX_HEALTH = 100;
    private static final int BASE_VALUES = 5;

    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this(name, BASE_VALUES, BASE_VALUES, BASE_VALUES);
    }

    public Character(String name, int power, int agility, int intelligence) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустое или null");
        }

        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = MAX_HEALTH;
    }

    public abstract void attack(Character opponent);

    public void printHealth(Character opponent) {
        System.out.printf("У противника осталось %d здоровья\n", opponent.getHealth());
    }

    public void healthCheck(Character opponent) {
        if (opponent.getHealth() <= 0) {
            throw new IllegalArgumentException("Оппонент проиграл");
        }
    }
}