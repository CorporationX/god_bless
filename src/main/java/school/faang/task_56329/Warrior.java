package school.faang.task_56329;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " attacks " + opponent.getName()
                + " for " + this.strength + " damage");
        opponent.health -= strength;
    }
}
