package faang.school.godbless.multithreading.heroes;

public class Swordsman extends Soldier {

    private SoldierType soldierType;

    public Swordsman(int power) {
        super(power);
        soldierType = SoldierType.SWORDSMAN;
    }

    @Override
    public SoldierType getType() {
        return soldierType;
    }
}
