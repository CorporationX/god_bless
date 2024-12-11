package school.faang.task_bjs243898;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
        power = 3;
        dexterity = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character enemy) {
        enemy.health -= this.dexterity;
    }
}
