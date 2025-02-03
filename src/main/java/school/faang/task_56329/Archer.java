package school.faang.task_56329;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " attacks " + opponent.getName()
        + " for " + this.agility + " damage");
        opponent.health -= this.agility;
    }
}
