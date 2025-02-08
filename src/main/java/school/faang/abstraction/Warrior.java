package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        if (isCharacterDead(opponent)) {
            return;
        }
        opponent.setHealth(opponent.getHealth() - getStrength());
    }
}
