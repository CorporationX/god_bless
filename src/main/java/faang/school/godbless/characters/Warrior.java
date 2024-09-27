package faang.school.godbless.characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int health = this.getHealth();
        if (health > 0) {
            character.setHealth(character.getHealth() - this.getPower());
        } else {
            System.out.println("Character " + character.getName() + "`s health = 0");
        }
    }
}
