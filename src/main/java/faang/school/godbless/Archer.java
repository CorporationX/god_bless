package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void Attack(Character character) {
        character.health -= this.agility;
    }
}
