package faang.school.godbless.BJS2_18519;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int characterHp = character.getHitPoints();
        int archerDexterity = getDexterity();
        character.setHitPoints(characterHp - archerDexterity);
    }
}
