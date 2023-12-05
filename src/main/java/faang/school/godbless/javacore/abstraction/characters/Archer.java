package faang.school.godbless.javacore.abstraction.characters;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - this.agility);
    }

}