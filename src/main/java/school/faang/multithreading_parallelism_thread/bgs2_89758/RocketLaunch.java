package school.faang.multithreading_parallelism_thread.bgs2_89758;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor

public class RocketLaunch {
    
    private static final List<Integer> rocketLaunchTimes = new ArrayList<>(List.of(0));
    private static final int ROCKET_LAUNCH_TIME = 1000;
    @Getter
    private String name;
    @Getter
    private long launchTime;
    

    public int getNextAvailableLaunchTime() {

        return ROCKET_LAUNCH_TIME;
    }

    public void launch() {
        try {
            Thread.sleep(ROCKET_LAUNCH_TIME);
            System.out.printf("Ракета %d полетела \n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            System.out.print(e.getMessage());
        }
    }

    public void planRocketLaunches(@NonNull List<RocketLaunch> launches) {


        List<RocketLaunch> sortedRocketsByLaunchTime = launches.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(RocketLaunch::getLaunchTime))
                .toList();


    }
}