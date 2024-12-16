package school.faang.task_47698;

public class Swordsman extends Unit {
    private static final int DEFAULT_POWER = 7;

    public Swordsman() {
        super(DEFAULT_POWER);
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.SWORDSMAN;
    }

}
