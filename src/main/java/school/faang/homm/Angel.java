package school.faang.homm;

public class Angel extends Creature{
    public Angel() {
        super("Angel", 4, 4, 4, 4);
    }

    @Override
    public Integer getAmountOfDamage() {
        return this.level * this.attack * this.speed * 2 - this.defense;
    }
}
