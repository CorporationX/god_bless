package faang.school.godbless;

public class Archer extends Character {
    Archer(String name) {
        this.name = name;
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }
    public void attack(Character enemy) {
        enemy.health = enemy.health - agility;
    }
}
