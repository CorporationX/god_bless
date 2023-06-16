package faang.school.godbless;

public class Archer extends Character {
    Archer(String name) {
        super(name, 3, 10, 5);
    }
    public void attack(Character enemy) {
        enemy.health = enemy.health - agility;
    }
}
