package faang.school.godbless.third;

public class Archer extends Character {
    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }

    public Archer(String name) {
        super(name, 3, 10, 5);
    }
}
