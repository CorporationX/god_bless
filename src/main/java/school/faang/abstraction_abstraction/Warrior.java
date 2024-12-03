package school.faang.abstraction_abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " Warrior atacked " + opponent.getName());
        opponent.health -= power;
        System.out.println(opponent.getName() + " now has " + opponent.getHealth() + " health.");
    }
}
