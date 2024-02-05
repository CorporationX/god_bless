package faang.school.godbless.java_core.abstarct_abstract;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= strength;
    }


}
