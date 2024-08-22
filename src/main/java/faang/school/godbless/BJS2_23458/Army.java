package faang.school.godbless.BJS2_23458;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Archer> archers = new ArrayList<>();
    private List<Swordsman> swordsmen = new ArrayList<>();
    private List<Mage> mages = new ArrayList<>();

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);

        Thread calculateArcher = new Thread( () -> {
            for(var arher : archers) {
                totalPower.addAndGet(arher.getPower());
            }
        });

        Thread calculateSwordsmen = new Thread( () -> {
            for(var swordman : swordsmen) {
                totalPower.addAndGet(swordman.getPower());
            }
        });

        Thread calculateMages = new Thread( () -> {
            for(var mage : mages) {
                totalPower.addAndGet(mage.getPower());
            }
        });

        calculateArcher.start();
        calculateSwordsmen.start();
        calculateMages.start();

        try {
            calculateArcher.join();
            calculateSwordsmen.join();
            calculateMages.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return totalPower.get();
    }


    public void addUnit(Character character) {
        if(character instanceof Archer) {
            archers.add((Archer) character);
        } else if (character instanceof Swordsman) {
            swordsmen.add((Swordsman) character);
        } else if(character instanceof Mage) {
            mages.add((Mage) character);
        }
    }
}
