package faang.school.godbless.multithreading.heroes;

public class Mage extends Soldier {

    private SoldierType soldierType;

    public Mage(int power) {
        super(power);
        soldierType = SoldierType.MAGE;
    }


    @Override
    public SoldierType getType() {
        return soldierType;
    }
}
