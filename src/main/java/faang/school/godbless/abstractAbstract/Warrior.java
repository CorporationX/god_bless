package faang.school.godbless.abstractAbstract;

public class Warrior extends Character {
    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
