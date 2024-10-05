package school.faang.pers_warrior;

public class Archer extends Character {
    public Archer(String name, Integer strength, Integer agility, Integer intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character character) {
        Integer hitPointsCharacter = character.getHitPoints();
        if (hitPointsCharacter <= 0) {
            throw new IllegalArgumentException("character is dead");
        } else {
            Integer newPointsCharacter = hitPointsCharacter - getAgility();
            character.setHitPoints(newPointsCharacter);
        }
    }
}
