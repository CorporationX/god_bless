package school.faang.task_47698;

public class Archer extends Unit {
    private static final int DEFAULT_POWER = 5;

    public Archer() {
        super(DEFAULT_POWER);
    }

    @Override
    public UnitType getUnitType() {
        return UnitType.ARCHER;
    }

}
