package school.faang.distributedarmy;

public class ThreadArm extends Thread {
    private final Unit unit;

    public ThreadArm(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        Army.result += unit.getPower();
        System.out.println("Я подсчитал " + Thread.currentThread().getName() + " моя сила равна " + unit.getPower());
    }
}
