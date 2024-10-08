package school.faang.homm;

public class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 2, 2, 2, 2);
    }

    @Override
    public Integer getAmountOfDamage() {
        return this.level * this.attack * this.speed - this.defense;
    }
}
