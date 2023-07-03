package faang.school.godbless.heroesArmyPower;

public class UnitPowerThread extends Thread{
    private final Unit unit;

    UnitPowerThread(Unit unit){
        this.unit = unit;
    }

    @Override
    public void run(){
        int power = unit.getPower();
    }
    int getPower(){
        return unit.getPower();
    }
}
