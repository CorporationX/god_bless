package school.faang.task_79235;

import lombok.Data;

@Data
abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.intelligence = 5;
        this.agility = 5;
        this.strength = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public void attack(Character opponent) {
    }

    public boolean checkHealth(String opponentName, int opponentHealth, int damage) {
        if (opponentHealth == 0) {
            System.out.println(getName() + " наносит: " + damage + " единиц урона, но " + opponentName + " уже убит");
            return false;
        }

        if (damage >= opponentHealth) {
            System.out.println(getName() + " наносит: " + damage + " единиц урона. " + opponentName + " убит");
            return false;
        }
        return true;
    }
}
