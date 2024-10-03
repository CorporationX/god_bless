package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setForce(10);
        setSkill(5);
        setIntellect(3);
    }

    @Override
    public void attack(Character character) {
        Integer hitPointsCharacter = character.getHitPoints();
        Integer newPointsCharacter = hitPointsCharacter - getForce();
        character.setHitPoints(newPointsCharacter);
    }
}
