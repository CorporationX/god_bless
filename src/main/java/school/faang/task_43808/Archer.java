package school.faang.task_43808;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character player) {
        player.health -= this.dexterity;
    }
}
