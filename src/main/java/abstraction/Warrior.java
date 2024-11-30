package abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(int power, int dexterity, int intelligence) {
        super(10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.hp = character.hp - this.power;
    }
}
