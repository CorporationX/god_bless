package faang.school.godbless;

import faang.school.godbless.Characters.Archer;
import faang.school.godbless.Characters.Character;
import faang.school.godbless.Characters.Mage;
import faang.school.godbless.Characters.Swordsman;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    @Setter
    private List<Character> army = new ArrayList<>();

    public int calculateTotalPower(){
        List<Thread> threads = new ArrayList<>();
        AtomicInteger totalPower = new AtomicInteger();
        for (var unit : army) {
            Thread thread = new Thread(() -> totalPower.addAndGet(unit.getPower()));
            thread.start();
            threads.add(thread);
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        });
        return totalPower.get();
    }

    public static void main(String[] args){
        Army a = new Army();
        a.setArmy(Arrays.asList(
                new Archer("archer", 25),
                new Swordsman("Swordsman", 10),
                new Mage("Mage", 100)
        ));
        System.out.println(a.calculateTotalPower());
        System.out.println("Done");
    }
}
