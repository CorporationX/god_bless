package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String setName) {
        super(setName);
        setPower(3);
        setAgility(10);
        setIntelligence(5);
    }

    public void attack(Character character) {
        character.health = character.health - getAgility();
    }
}
