package faang.school.godbless.javacore.abstraction.characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - this.strength);
    }

}