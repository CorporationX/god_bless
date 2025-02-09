package school.faang.BJS2_56484;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int power, int agility, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.hasHealth()){
            opponent.setHealth(opponent.getHealth() - getPower());
        }else {
            System.out.println("Противник " + opponent.getName() + " повержен!");
        }
    }

}
