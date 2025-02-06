package school.faang.task_56407;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 5, 3, 10);
    }

    public void attack(Character opponent) {
        if (opponent.healthCheck()) {
            System.out.println("У оппонента нет здоровья");
        } else {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
        }
    }
}
