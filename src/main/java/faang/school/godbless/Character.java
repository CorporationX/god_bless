package faang.school.godbless;

import lombok.Data;

@Data
abstract class Character {
    private final String name;
    protected int power;
    protected int agility;
    protected int smart;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int smart) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.smart = smart;
    }

    abstract void attack(Character character);

    public boolean isAlive(int damage) {
        return this.health > damage;
    }

    protected static void dealDamage(Character enemy, int damage) {
        if (enemy.isAlive(damage)) {
            enemy.health -= damage;
        } else {
            enemy.health = 0;
            System.out.println("Enemy is dead!");
        }
    }
}
