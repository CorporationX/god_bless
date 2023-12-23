package faang.school.godbless.multithreading.parallelism.heroesArmy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {

    List<Creature> listArmy = new ArrayList<>();
    List<CreatureThread> listArchers = new ArrayList<>();
    List<CreatureThread> listSwordmans = new ArrayList<>();
    List<CreatureThread> listMages = new ArrayList<>();

    public int calculateTotalPower(List<Creature> listArmy) throws InterruptedException {

        int totalPowerArchers = 0;
        int totalPowerSwordmans = 0;
        int totalPowerMages = 0;

        for (Creature creature : listArmy) {
            if (creature instanceof Archer) {
                CreatureThread archer = new CreatureThread(creature);
                listArchers.add(archer);
                archer.start();
            }
            if (creature instanceof Swordman) {
                CreatureThread swordman = new CreatureThread(creature);
                listSwordmans.add(swordman);
                swordman.start();
            }
            if (creature instanceof Mage) {
                CreatureThread mage = new CreatureThread(creature);
                listMages.add(mage);
                mage.start();
            }
        }

        for (CreatureThread creatureThread : listArchers) {
            creatureThread.join();
            totalPowerArchers += creatureThread.getPower();
        }
        System.out.println("Total power Archers - " + totalPowerArchers);

        for (CreatureThread creatureThread : listSwordmans) {
            creatureThread.join();
            totalPowerSwordmans += creatureThread.getPower();
        }
        System.out.println("Total power Swordmans - " + totalPowerSwordmans);

        for (CreatureThread creatureThread : listMages) {
            creatureThread.join();
            totalPowerMages += creatureThread.getPower();
        }
        System.out.println("Total power Mages - " + totalPowerMages);

        return totalPowerSwordmans + totalPowerArchers + totalPowerMages;

    }

    public void addCreatureInArmy(Creature creature) {
        listArmy.add(creature);
    }
}
