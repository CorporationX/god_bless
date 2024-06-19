package faang.school.godbless.multithreading.heroes;

public class Archer extends Soldier {

    private SoldierType soldierType;

    public Archer(int power) {
        super(power);
        soldierType = SoldierType.ARCHER;
    }

    @Override
    public SoldierType getType() {
        return soldierType;
    }
}
