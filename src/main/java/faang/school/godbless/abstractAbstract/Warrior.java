package faang.school.godbless.abstractAbstract;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.name = name;
        this.strength = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - 10);
    }
}
