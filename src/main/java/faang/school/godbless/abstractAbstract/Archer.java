package faang.school.godbless.abstractAbstract;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.name = name;
        this.strength = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - 10);
    }
}
