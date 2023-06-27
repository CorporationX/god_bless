package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;

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
    public void run() {
        long startTime = System.currentTimeMillis();
        launch();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Затрачено времени: " + timeSpent + " миллисекунд");
    }
}
