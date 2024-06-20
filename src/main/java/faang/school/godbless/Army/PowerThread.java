package faang.school.godbless.Army;

public class PowerThread extends Thread{

    private final Unit unit;

    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run(){
        power = unit.getPower();
    }

    public int getPower(){
        return power;
    }

}
