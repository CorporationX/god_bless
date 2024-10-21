package school.faang.m1s3.bjs2_36282_spacex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
@Getter
@RequiredArgsConstructor
public class RocketLaunch {
    private final String name;
    private final LocalTime launchTime;

    public void launch() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted" + e.getMessage(), e);
        }
        System.out.printf("%s was launched%n", name);
    }
}
