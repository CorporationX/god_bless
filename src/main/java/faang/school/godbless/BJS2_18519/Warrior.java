package faang.school.godbless.BJS2_18519;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int characterHp = character.getHitPoints();
        int warriorPower = getPower();
        character.setHitPoints(characterHp - warriorPower);
    }
}
