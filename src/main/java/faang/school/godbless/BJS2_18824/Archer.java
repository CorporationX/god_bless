package faang.school.godbless.BJS2_18824;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = this.dexterity;
        character.health -= damage;
    }
}
