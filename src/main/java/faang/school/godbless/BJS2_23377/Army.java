package faang.school.godbless.BJS2_23377;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit){
        if(unit == null) {
            throw new IllegalArgumentException("No unit added");
        }

        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<MyThread> threads = new ArrayList<>();
        for (Unit unit : army){
            MyThread thread = new MyThread(unit);
            thread.start();
            thread.join();
            threads.add(thread);
        }

        return threads.stream().mapToInt(MyThread::getSumPower).sum();
    }
}
