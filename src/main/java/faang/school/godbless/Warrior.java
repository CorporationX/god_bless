package faang.school.godbless;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
    }

    public Warrior(int strength, int agility, int intelligence) {
        super(10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int health = character.getHealth() - getStrength();
        if(health <= 0) {
            System.out.println("You died");
        }
        else {
            System.out.println("у вас осталось " + health + " здоровья");
        }
    }
}
