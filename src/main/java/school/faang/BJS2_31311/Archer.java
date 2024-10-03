package school.faang.BJS2_31311;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
        this.setIntellect(5);
    }

    @Override
    protected void attack(Character targetCharacter) {
        targetCharacter.setHp(targetCharacter.getHp() - agility);
    }
}
