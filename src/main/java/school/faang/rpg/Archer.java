package school.faang.rpg;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setDexterity(10);
        this.setIntellect(5);
    }

    @Override
    public void attack(Character opponent) {
        if (this.isAlive() && opponent.isAlive()) {
            System.out.println(this.getName() + " атакует " + opponent.getName());
            opponent.receiveDamage(this.getDexterity());
            if (!opponent.isAlive()) {
                System.out.println(opponent.getName() + ", попал под обстрел и был убит!");
            }
        } else if (!this.isAlive()) {
            System.out.println(this.getName() + " мертв, не может атаковать.");
        } else {
            System.out.println(opponent.getName() + " уже мертв.");
        }
    }
}
