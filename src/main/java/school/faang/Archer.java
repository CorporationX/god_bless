package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setForce(3);
        setSkill(10);
        setIntellect(5);
    }

    @Override
    public void attack(Character character) {
        Integer hitPointsCharacter = character.getHitPoints();
        Integer newPointsCharacter = hitPointsCharacter - getSkill();
        character.setHitPoints(newPointsCharacter);
    }
}
