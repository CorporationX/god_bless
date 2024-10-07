package school.faang.homm;

public class Swordman extends Creature{
    public Swordman() {
        super("Swordman", 3, 3, 3, 3);
    }

    @Override
    public Integer getAmountOfDamage() {
        return this.level * this.attack * this.speed - this.defense;
    }
}
