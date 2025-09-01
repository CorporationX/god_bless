package school.faang.abstraction;

import lombok.ToString;

@ToString(callSuper = true)
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character opponent) {
        int damage = this.agility;
        checkHitPointsBeforeAttack(opponent, damage);
        opponent.hitPoints -= damage;

        System.out.printf("Character %s attacked Character %s - %s hitPoints left%n",
                this.name, opponent.name, opponent.hitPoints);
    }
}
