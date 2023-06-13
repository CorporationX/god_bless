package faang.school.godbless.characters;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.health -= this.agility;
    }
}
