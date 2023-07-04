package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class RocketLaunch implements Runnable {
    private String name;
    private LocalDateTime date;

    public void launch(){
        try {
            System.out.println("Rocket " + name +" is preparing..");
            Thread.sleep(1000);
            System.out.println("Rocket " + name + " is launched");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SneakyThrows
    public void run() {
        if (date.isAfter(LocalDateTime.now())){
            Duration duration = Duration.between(LocalDateTime.now(),date);
            Thread.sleep(duration.toMillis());
        }
        long startTime = System.currentTimeMillis();
        launch();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Затрачено времени: " + timeSpent + " миллисекунд");
    }
}
