package school.faang;

public class Archer extends Character{
    public Archer(String name){
        super(name);
        this.Strength = 3;
        this.Agility = 10;
        this.Intelligence = 5;
    }
    @Override
    public void attack(Character enemy) {
        int hp=enemy.HeathPoints-this.Agility;
        enemy.setHeathPoints(hp);
        if (enemy.HeathPoints<=0){
            System.out.println("Enemy is dead");
        }
    }
}
