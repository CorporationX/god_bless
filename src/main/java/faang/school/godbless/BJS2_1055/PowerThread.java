package faang.school.godbless.BJS2_1055;

public class PowerThread extends Thread {
    private int power;
    private final Unit unit;

    public PowerThread(Unit unit){
        this.unit = unit;
    }
    @Override
    public void run() {
        power = unit.getPower();
    }

    public int getPower(){
        return power;
    }
}
