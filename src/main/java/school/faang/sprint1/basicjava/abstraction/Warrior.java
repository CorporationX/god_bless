package school.faang.sprint1.basicjava.abstraction;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        if (opponent.checkHealth()){
            opponent.setHealth(0);
        }
    }
}
