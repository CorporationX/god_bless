package faang.school.godbless.Theywereverynicebutextremelypoor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Поток " + threadName + " выполняет задачу " + chore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        System.out.println("Поток " + threadName + " закончил задачу " + chore);
    }
}
