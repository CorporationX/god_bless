package bjs2_85596;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.agility = 10;
        this.strength = 3;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.agility;
        opponent.reduceHealth(damage);
        System.out.println(this.name + " атакует " + opponent.name
                + " наносит " + damage + "урона, оставшееся здоровье " + opponent.health);
    }
}
