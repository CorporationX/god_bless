package faang.school.godbless.abstracting;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        super.force = 3;
        super.dexterity = 10;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        int damage = dexterity;
        character.health -= damage;
    }
}
