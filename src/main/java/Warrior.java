public class Warrior extends Character {
    Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
