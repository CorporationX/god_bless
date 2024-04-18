package faang.school.godbless.army_of_heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Army {
    private final List<Archer> archers = new ArrayList<>();
    private final List<Swordsman> swordsmans = new ArrayList<>();
    private final List<Mage> mages = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(50));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(100));
        army.addUnit(new Mage(200));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

    private void addUnit(Archer archer) {
        this.archers.add(archer);
    }

    private void addUnit(Swordsman swordsman) {
        this.swordsmans.add(swordsman);
    }

    private void addUnit(Mage mage) {
        this.mages.add(mage);
    }

    public Integer calculateTotalPower() throws InterruptedException {
        AtomicInteger total = new AtomicInteger(0);
        Thread calcTotalPowersArches = new Thread(() -> {
            total.getAndAdd(archers.stream()
                    .flatMapToInt(archer -> IntStream.of(archer.getPower())).sum());
        });
        Thread calcTotalPowerSwordsman = new Thread(() -> {
            total.getAndAdd(swordsmans.stream()
                    .flatMapToInt(swordsman -> IntStream.of(swordsman.getPower())).sum());
        });

        Thread calcTotalPowersMage = new Thread(() -> {
            total.getAndAdd(mages.stream()
                    .flatMapToInt(mage -> IntStream.of(mage.getPower())).sum());
        });

        calcTotalPowersArches.start();
        calcTotalPowerSwordsman.start();
        calcTotalPowersMage.start();

        calcTotalPowersArches.join();
        calcTotalPowerSwordsman.join();
        calcTotalPowersMage.join();
        
        return total.get();
    }
}
