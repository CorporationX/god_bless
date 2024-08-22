package faang.school.godbless.task23455;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Army {
    private List<Archer> archerSubdivision;
    private List<Swordsman> swordsmanSubdivision;
    private List<Mage> mageSubdivision;

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger power = new AtomicInteger();

        Thread archerThread = new Thread(() -> {power.addAndGet(archerSubdivision.stream()
                .collect(Collectors.summingInt(Archer::getPower)));});

        Thread swordsmanThread = new Thread(() -> {power.addAndGet(swordsmanSubdivision.stream()
                .collect(Collectors.summingInt(Swordsman::getPower)));});

        Thread mageThread = new Thread(() -> {power.addAndGet(mageSubdivision.stream()
                .collect(Collectors.summingInt(Mage::getPower)));});


        archerThread.start();
        swordsmanThread.start();
        mageThread.start();
        archerThread.join();
        swordsmanThread.join();
        mageThread.join();

        return power.get();
    }

    public Army() {
        archerSubdivision = new ArrayList<>();
        swordsmanSubdivision = new ArrayList<>();
        mageSubdivision = new ArrayList<>();
    }

    public void addArcher(Archer archer){
        archerSubdivision.add(archer);
   }

   public void addSwordsman(Swordsman swordsman){
        swordsmanSubdivision.add(swordsman);
   }

   public void addMage(Mage mage){
        mageSubdivision.add(mage);
   }
}
