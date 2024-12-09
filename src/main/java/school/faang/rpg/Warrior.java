package school.faang.rpg;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setDexterity(5);
        this.setIntellect(3);
    }

    @Override
    public void attack(Character opponent) {
        if (this.isAlive() && opponent.isAlive()) {
            System.out.println(this.getName() + " атакует " + opponent.getName());
            opponent.receiveDamage(this.getDexterity());
            if (!opponent.isAlive()) {
                System.out.println(opponent.getName() + ", был убит в бою!");
            }
        } else if (!this.isAlive()) {
            System.out.println(this.getName() + " мертв, не может атаковать.");
        } else {
            System.out.println(opponent.getName() + " уже мертв.");
        }
    }
}
