package SpaceX;

import java.time.LocalDateTime;

public class RocketLaunch {
    private String name;
    private LocalDateTime startTime;

    public RocketLaunch(String name, LocalDateTime startTime) {
        this.name = name;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The rocket " + name + " is launched");
    }

    @Override
    public String toString() {
        return "RocketLaunch{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
