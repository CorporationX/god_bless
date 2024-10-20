package school.faang.Mnogopotochka.ParallelismThread.BJS2_36278;

import java.util.ArrayList;
import java.util.List;

import static school.faang.Mnogopotochka.ParallelismThread.BJS2_36278.RocketLaunch.planRocketLaunches;

public class Main {
    private static final List<RocketLaunch> rocketLaunches = new ArrayList<>();

    public static void main(String[] args) {
        rockets();
        planRocketLaunches(rocketLaunches);
    }

    private static void rockets(){
        rocketLaunches.add(new RocketLaunch("Zarya", 1000));
        rocketLaunches.add(new RocketLaunch("Mars", 3000));
        rocketLaunches.add(new RocketLaunch("Venera", 5000));
        rocketLaunches.add(new RocketLaunch("Luna", 7000));
        rocketLaunches.add(new RocketLaunch("Soyuz", 9000));
        rocketLaunches.add(new RocketLaunch("Letim", 12000));
    }
}
