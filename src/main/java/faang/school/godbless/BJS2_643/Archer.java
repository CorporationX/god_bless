package faang.school.godbless.BJS2_643;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
    }

    public Archer(int power, int dexterity, int intelligence) {
        super(3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.health = character.health - this.dexterity;
    }
}

