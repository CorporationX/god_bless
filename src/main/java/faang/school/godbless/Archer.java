package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
    }

    public Archer() {
        super(3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth()-this.getDexterity());
    }
}
