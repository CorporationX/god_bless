package school.faang.task_bjs243898;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        power = 3;
        dexterity = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character enemy) {
        enemy.health -= this.dexterity;
    }
}
