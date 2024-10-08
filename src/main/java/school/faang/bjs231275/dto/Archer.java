package school.faang.bjs231275.dto;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHalf(character.getHalf() - this.agility);
    }
}
