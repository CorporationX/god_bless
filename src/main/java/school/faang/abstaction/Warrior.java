package school.faang.abstaction;

public class Warrior extends school.faang.abstaction.Character {


    public Warrior(String name) {
        super(name, 5, 10, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}
