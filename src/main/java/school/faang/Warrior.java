package school.faang;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name,5,10,3);
    }



    @Override
    public void attack(Character opponent) {
       opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}
