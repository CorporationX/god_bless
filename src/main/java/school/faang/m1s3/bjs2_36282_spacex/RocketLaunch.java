package school.faang.m1s3.bjs2_36282_spacex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Getter
@RequiredArgsConstructor
public class RocketLaunch {
    private final String name;
    private final LocalTime launchTime;

    public void launch() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread was interrupted" + e.getMessage(), e);
        }
        System.out.println(name + " was launched");
    }
}
