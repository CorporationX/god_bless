package faang.school.godbless.BJS2_4340;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.dexterity;
    }
}
