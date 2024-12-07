package school.faang.task_bjs243898;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        power = 10;
        dexterity = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character enemy) {
        enemy.health -= this.power;
    }
}
