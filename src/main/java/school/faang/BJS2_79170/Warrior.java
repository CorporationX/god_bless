package school.faang.BJS2_79170;

public class Warrior extends Character {


    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        if(opponent.getHealth() != 0)
            opponent.setHealth(opponent.getHealth() - power);
            if (opponent.getHealth() < 0) {
                opponent.setHealth(0);
        }
    }
}
