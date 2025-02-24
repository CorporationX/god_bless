package school.faang.taskabstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.intelligence = 3;
        this.agility = 5;
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.name + " наносит урон противнику!");
        character.health -= this.power;
        System.out.println("Уровень здоровья персонажа " + character.name + " = " + character.health);
    }
}
