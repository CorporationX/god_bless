package school.faang.sprint_3.task_48249;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RocketLaunch {
    private static final int LAUNCH_DELAY = 1000;

    private final String name;
    private final int launchTime;

    public void launch() {
        try {
            Thread.sleep(LAUNCH_DELAY);
            System.out.println("Launching " + name + " at " + launchTime);
        } catch (InterruptedException e) {
            System.out.println("Launch interrupted");
            Thread.currentThread().interrupt();
        }

    }
}
