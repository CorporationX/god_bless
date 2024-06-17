package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String setName) {
        super(setName);
        setPower(10);
        setAgility(5);
        setIntelligence(3);
    }

    public void attack(Character character) {
        character.health = character.health - getPower();
    }
}