package school.faang.sprint3.mightandmagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Thread> threads;

    List<Archer> archers = new ArrayList<>();
    List<Mage> mages25 = new ArrayList<>();
    List<Mage> mages50 = new ArrayList<>();
    List<Swordsman> swordsmans = new ArrayList<>();

    Integer totalPower = 0;

    public void addUnit(Object obj) {
        if (obj instanceof Archer) {
            archers.add((Archer) obj);
        } else if (obj instanceof Mage && ((Mage) obj).getPower() == 25) {
            mages25.add((Mage) obj);
        } else if (obj instanceof Mage && ((Mage) obj).getPower() == 50) {
            mages50.add((Mage) obj);
        } else if (obj instanceof Swordsman) {
            swordsmans.add((Swordsman) obj);
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        Thread one = new Thread(() -> totalPower += archers.stream().map(Archer::getPower).reduce(Integer::sum).orElse(0));
        threads.add(one);

        Thread two = new Thread(() -> totalPower += mages25.stream().map(Mage::getPower).reduce(Integer::sum).orElse(0));
        threads.add(two);

        Thread three = new Thread(() -> totalPower += mages50.stream().map(Mage::getPower).reduce(Integer::sum).orElse(0));
        threads.add(three);

        Thread four = new Thread(() -> totalPower += swordsmans.stream().map(Swordsman::getPower).reduce(Integer::sum).orElse(0));
        threads.add(four);

        for (Thread thread : threads) {
            try {
                thread.start();

                thread.join();
            } catch (Exception e) {
                System.out.println("Invalid process");
            }
        }
        return totalPower;
    }
}
