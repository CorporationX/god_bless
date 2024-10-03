package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    protected void attack(Character character) {
        character.setHp(character.getHp() - agility);
    }

}
