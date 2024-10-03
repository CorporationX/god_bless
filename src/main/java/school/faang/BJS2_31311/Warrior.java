package school.faang.BJS2_31311;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntellect(3);
    }

    @Override
    protected void attack(Character targetCharacter) {
        targetCharacter.setHp(targetCharacter.getHp() - strength);
    }
}
