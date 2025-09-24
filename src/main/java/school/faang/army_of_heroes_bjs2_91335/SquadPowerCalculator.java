package school.faang.army_of_heroes_bjs2_91335;

import java.util.concurrent.Callable;

public class SquadPowerCalculator implements Callable<Integer> {

    private final Squad squad;

    public SquadPowerCalculator(Squad squad) {
        this.squad = squad;
    }


    @Override
    public Integer call() throws Exception {
        return squad.calculateSquadPower();
    }
}
