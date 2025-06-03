package school.faang.bjs2_79351;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setAgility(5);
        setIntellect(3);
        setStrength(10);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }
}
