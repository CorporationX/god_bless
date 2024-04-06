package faang.school.godbless.characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character ch) {
        int health = this.getHealth();
        if (health > 0) {
            ch.setHealth(ch.getHealth() - this.getPower());
        } else {
            System.out.println("Character " + ch.getName() + " have bin health = 0");
        }
    }
}
