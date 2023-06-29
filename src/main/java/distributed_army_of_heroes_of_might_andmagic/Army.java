package distributed_army_of_heroes_of_might_andmagic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army extends Thread{
    private List<Unit> units;
    public Army() {
        units = new ArrayList<>();
    }
    public void addUnit(Unit unit){
        units.add(unit);
    }
    public int calculateTotalPower(){
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (var unit:units){
            Thread thread = new Thread(() -> {
                int unitPower = unit.getPower();
                totalPower.addAndGet(unitPower);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower.get();
    }

    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(5));
        army.addUnit(new Mage(30));

        System.out.println(army.calculateTotalPower());
    }
}
