package derschrank.sprint03.task02.bjstwo_47918.units;

public abstract class Unit {
    private final String typeOfUnit;
    private final int power;

    public Unit(String typeOfUnit, int power) {
        this.typeOfUnit = typeOfUnit;
        this.power = power;
    }


    public String getTypeOfUnit() {
        return typeOfUnit;
    }

    public int getPower() {
        return power;
    }
}
