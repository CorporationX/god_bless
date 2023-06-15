package Task3;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public int attack(Character character) {
        int attacks = character.getHealth() - this.force;
        return character.setHealth(attacks);
    }
}
