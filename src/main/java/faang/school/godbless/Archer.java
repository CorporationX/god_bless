package faang.school.godbless;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character target) {
        int damage = this.dexterity;
        target.hp = target.hp - damage;
    }

}
