package bjs2_56245;

import java.time.OffsetDateTime;

public record RocketLaunch(String name, OffsetDateTime launchTime) {
    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.printf("Ракета %s запущена%n", name);
    }
}
