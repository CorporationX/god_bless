package faang.school.godbless.BJS2_7731;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}

