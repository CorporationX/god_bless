package faang.school.godbless.distributed_army_of_heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Creature> creatures;

    List<CreatureThread> archerThreads = new ArrayList<>();
    List<CreatureThread> mageThreads = new ArrayList<>();
    List<CreatureThread> swordsmanThreads = new ArrayList<>();

    public Army(List<Creature> creatures) {
        this.creatures = creatures;
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }

    public int calculateTotalPower() throws InterruptedException {

        for (Creature creature : creatures){
            if (creature.isArcher()){
                CreatureThread creatureThread = new CreatureThread(creature);
                archerThreads.add(creatureThread);
                creatureThread.start();
            } else if (creature.isSwordsman()) {
                CreatureThread creatureThread = new CreatureThread(creature);
                mageThreads.add(creatureThread);
                creatureThread.start();
            } else if (creature.isMage()) {
                CreatureThread creatureThread = new CreatureThread(creature);
                swordsmanThreads.add(creatureThread);
                creatureThread.start();
            }
        }
        return getTotal();
    }

    private int getTotal() throws InterruptedException {
        int totalArcherPower = getPowerSum(archerThreads);
        int totalMagePower = getPowerSum(mageThreads);
        int totalSwordsmanPower = getPowerSum(swordsmanThreads);

        System.out.println("Archer = " + totalArcherPower);
        System.out.println("Mage = " + totalMagePower);
        System.out.println("Swordsman = " + totalSwordsmanPower);

        return totalArcherPower + totalMagePower + totalSwordsmanPower;
    }

    private int getPowerSum (List<CreatureThread> creatures) throws InterruptedException {
        int totalPower = 0;
        for (CreatureThread creatureThread : creatures){
            creatureThread.join();
            totalPower += creatureThread.getPower();
        }
        return totalPower;
    }
}
