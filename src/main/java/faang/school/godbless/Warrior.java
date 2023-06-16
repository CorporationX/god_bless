package faang.school.godbless;

public class Warrior extends Character {
    Warrior(String name) {
        this.name = name;
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character enemy) {
        enemy.health = enemy.health - strength;
    }
}
