package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Divisions;

import java.util.concurrent.Callable;

public class GatheringPower implements Callable<Integer> {

    private final Divisions divisions;

    public GatheringPower(Divisions divisions) {
        this.divisions = divisions;
    }

    public int getPowers() {
        return divisions.getPower();
    }

    @Override
    public Integer call() {
        return getPowers();
    }
}
