package faang.school.godbless.task23455;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Army {
    private List<Unit> subdivision = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger allPower = new AtomicInteger();

        int power = subdivision.stream().collect(Collectors.summingInt(Unit::getPower));
        Thread unitThread = new Thread(() -> allPower.addAndGet(power));

        unitThread.start();
        unitThread.join();
        return allPower.get();
    }

    public void addArcher(Unit unit){
        subdivision.add(unit);
   }
    public void addSwordsman(Unit unit){
        subdivision.add(unit);
    }
    public void addMage(Unit unit){
        subdivision.add(unit);
   }
}
