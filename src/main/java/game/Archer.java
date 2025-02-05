package game;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " shoots at " + opponent.getName() + " with agility " + agility);
        opponent.takeDamage(agility);
    }
}
