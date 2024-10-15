package school.faang.firstStream.BJS2_31311;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character targetCharacter) {
        targetCharacter.setHp(targetCharacter.getHp() - strength);
    }
}
