package school.faang.BJS2_31363;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5 ,3);
    }

    @Override
    public void attack(Character Enemy){
        if (Enemy != null) {
            Enemy.setHealth(Enemy.getHealth() - power);
        }
    }
}
