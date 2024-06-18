package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int power, int intellect, int sleight) {
        super(3, 5, 10);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.sleight;
    }
}
