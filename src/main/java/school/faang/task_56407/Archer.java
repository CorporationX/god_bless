package school.faang.task_56407;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 5, 10, 3);
    }

    public void attack(Character opponent) {
        if (opponent.healthCheck()) {
            System.out.println("У оппонента нет здоровья");
        } else {
            opponent.setHealth(opponent.getHealth() - this.getAgility());
        }

    }
}
