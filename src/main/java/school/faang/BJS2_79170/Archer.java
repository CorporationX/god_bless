package school.faang.BJS2_79170;

public class Archer extends Character {
    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }
    
    public Archer(String name) {
        super(name, 3, 10, 5);
    }
    
    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - dexterity);
        if (opponent.getHealth() < 0) {
            opponent.setHealth(0);
        }

    }


}
