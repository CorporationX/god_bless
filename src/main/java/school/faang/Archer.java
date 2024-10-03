package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        if (enemy == null) {
            System.out.println(this.name + " не может атаковать, враг не найден.");
            return;
        }

        enemy.takeDamage(this.dexterity);
        System.out.println(this.name + " атакует - " + enemy.getName() + " нанося : " + this.dexterity + " урон");
    }
}
