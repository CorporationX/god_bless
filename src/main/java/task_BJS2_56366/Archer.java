package task_BJS2_56366;

import lombok.NonNull;

public class Archer extends Character {

    public Archer(@NonNull String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getAgility();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}




