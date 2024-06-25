package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_9_spaceX;

import java.time.LocalDateTime;

public record RocketLaunch(String name, LocalDateTime timeLaunch) implements Runnable {

    @Override
    public void run() {
        System.out.println(name + ": на старт.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + ": улетел, но обещал вернуться");
    }
}
