package faang.school.godbless.Multithreading.ParallelismAndThread.task05_heroes;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PowerThread extends Thread{

    private final Unit unit;
    private int power;

    public int getPower() {
        return unit.getPower();
    }
    public void run() {
        power = unit.getPower();
    }
}
