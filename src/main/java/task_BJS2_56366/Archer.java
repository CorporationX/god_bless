package task_BJS2_56366;

import lombok.NonNull;

public class Archer extends Character {

    public Archer(@NonNull String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    public Archer(@NonNull String name) {
        super(name);
        super.setStrength(3);
        super.setAgility(10);
        super.setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getAgility();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}




