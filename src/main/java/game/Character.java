package game;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    protected void inflictDamage(int damage) {
        if (health == 0) {
            System.out.printf("%s уже мёртв!", name);
            return;
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.printf("%s получил урон в количестве: %d\nУ %s осталось %d хп!\n\n", name, damage, name, health);
    }

    public boolean isDead() {
        return health == 0;
    }
}
