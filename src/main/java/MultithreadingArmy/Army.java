package MultithreadingArmy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private List<Warrior> army = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        army.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Integer> totalPower = new ArrayList<>();

        for (Warrior warrior : army) {
            Thread thread = new Thread(() -> {
                totalPower.add(warrior.getPower());
                System.out.println(Thread.currentThread().getName() + ": " + warrior.getPower());
            });
            thread.start();
            thread.join();
        }

        return totalPower.stream().reduce(0, (acc, sum) -> acc + sum);
    }
}
