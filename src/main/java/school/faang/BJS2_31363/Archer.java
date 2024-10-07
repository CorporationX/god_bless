package school.faang.BJS2_31363;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character Enemy){
        if (Enemy != null) {
            Enemy.setHealth(Enemy.getHealth() - agility);
        }
    }
}
