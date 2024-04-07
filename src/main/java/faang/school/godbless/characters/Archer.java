package faang.school.godbless.characters;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth();
        if (health > 0) {
            character.setHealth( health - this.getAgility());
        } else {
            System.out.println("Character " + character.getName() + "`s health = 0");
        }
    }
}
