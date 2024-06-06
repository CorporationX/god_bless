package faang.school.godbless.abstracting;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.force = 10;
        super.dexterity = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        int damage = force;
        character.health -= damage;
    }
}
