package BJS2_23424_HoMM_Multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Army {
    private static final List<Unit> units = new ArrayList<>();

    public static void main(String[] args) {
        Army army = new Army();
        addUnit(new Archer(20));
        addUnit(new Swordsman(30));
        addUnit(new Mage(60));
        addUnit(new Mage(70));

        System.out.println(army.calculateTotalPower(units));
    }

    public int calculateTotalPower(List<Unit> units) {
        AtomicInteger totalPower = new AtomicInteger();
        Thread thread = new Thread(() -> totalPower.addAndGet(units.get(0).getPower()));
        thread.start();
        return totalPower.get();
    }

    public static void addUnit(Unit unit){
        units.add(unit);
    }
}
