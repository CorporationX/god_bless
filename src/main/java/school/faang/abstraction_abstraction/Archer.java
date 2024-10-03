package school.faang.abstraction_abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character character) {
        character.setHp(character.getHp() - this.getAgility());
    }
}
