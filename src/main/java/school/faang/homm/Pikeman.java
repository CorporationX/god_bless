package school.faang.homm;

public class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 1, 1, 1, 1);
    }

    @Override
    public Integer getAmountOfDamage() {
        return this.level * this.attack * this.speed - this.defense;
    }
}
