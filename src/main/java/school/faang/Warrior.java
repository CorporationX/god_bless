package school.faang;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.Strength = 10;
        this.Agility = 5;
        this.Intelligence = 3;
    }

    @Override
    public void attack(Character enemy) {
        int hp=enemy.HeathPoints-this.Strength;
        enemy.setHeathPoints(hp);
        if (enemy.HeathPoints<=0){
            System.out.println("Enemy is dead");
        }
    }
}
