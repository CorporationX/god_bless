package bjs2_85596;


import lombok.Getter;

@Getter

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.agility = 5;
        this.strength = 10;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.strength;
        opponent.reduceHealth(damage);
        System.out.println(this.name + " атакует " + opponent.name
                + " наносит " + damage + "урона, оставшееся здоровье " + opponent.health);
    }
}

