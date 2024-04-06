package faang.school.godbless.characters;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character ch) {
        int health = ch.getHealth();
        if (health > 0) {
            ch.setHealth( health - this.getAgility());
        } else {
            System.out.println("Character " + ch.getName() + " have bin health = 0");
        }
    }
}
