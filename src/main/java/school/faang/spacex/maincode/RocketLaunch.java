package school.faang.spacex.maincode;

import lombok.Getter;

@Getter
public class RocketLaunch {
    private String name;
    private int launchTime;

    public RocketLaunch(String name, int launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Запускается ракета " + name);
    }
}
