package school.faang.theywereverynicebutextremelypoor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_TIME = 1000;
    private String title;

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " Выполняет задачу " + title);
            Thread.sleep(SLEEP_TIME);
            log.info("Здача {} успешно выполнена!", title);
        } catch (InterruptedException e) {
            log.error("Здача {} была прирвана", title);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}