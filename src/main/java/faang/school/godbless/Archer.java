package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name, int power, int dexterity, int brain) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth()-getDexterity());
    }
}
