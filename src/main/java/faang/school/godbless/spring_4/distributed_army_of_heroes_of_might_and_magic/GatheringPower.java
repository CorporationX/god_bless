package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Divisions;

public class GatheringPower extends Thread {
    private static int powers = 0;

    private final Divisions divisions;

    public GatheringPower(Divisions divisions) {
        this.divisions = divisions;
    }

    @Override
    public void run() {
        getPowerDivision();
    }

    public static int getPower() {
        return powers;
    }

    private synchronized void getPowerDivision() {
        powers += divisions.getPower();
    }

}
