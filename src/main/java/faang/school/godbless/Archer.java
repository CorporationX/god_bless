package faang.school.godbless;


public class Archer extends Character{
    public Archer(String name) {
        super(name);
    }

    public Archer(int strength, int agility, int intelligence) {
        super(3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth() - getAgility();
        if(health <= 0) {
            System.out.println("You died");
        }
        else {
            System.out.println("у вас осталось " + health + " здоровья");
        }
    }
}
