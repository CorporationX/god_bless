package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intellect = 3;
    }

    @Override
    public void attack(Character target) {
        int damage = this.strength;
        target.hp = target.hp - damage;
    }

}

