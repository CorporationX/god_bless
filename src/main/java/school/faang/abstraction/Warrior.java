package school.faang.abstraction;

import lombok.ToString;

@ToString(callSuper = true)
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character opponent) {
        int damage = this.agility;
        checkHitPointsBeforeAttack(opponent, damage);
        opponent.hitPoints -= this.strength;

        System.out.printf("Character %s attacked Character %s - %s hitPoints left%n",
                this.name, opponent.name, opponent.hitPoints);
    }
}
