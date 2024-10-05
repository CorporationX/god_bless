package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3, 0);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " атакует, " + target.getName() + " и наносит " + this.strength + "урона");
        target.health -= this.strength;
        System.out.println(target.name + " теперь имеет: " + target.health + " здоровья");

    }
}
