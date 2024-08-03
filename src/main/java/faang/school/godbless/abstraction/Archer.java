package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.sleight;
    }
}
