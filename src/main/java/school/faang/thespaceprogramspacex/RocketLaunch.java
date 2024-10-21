package school.faang.thespaceprogramspacex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Rocket " + name + " is launching!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Launch of rocket " + name + " was interrupted.");
        }
    }
}

