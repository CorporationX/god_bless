package school.faang.firstStream.BJS2_31311;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character targetCharacter) {
        targetCharacter.setHp(targetCharacter.getHp() - agility);
    }
}
