package school.faang.task_47698;

public class Mage extends Unit {
    private static final int DEFAULT_POWER = 15;

    public Mage() {
        super(DEFAULT_POWER);
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.MAGE;
    }

}
