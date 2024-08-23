package faang.school.godbless.they_were_very_nice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        Thread.currentThread().getName();

        log.info("Задача %s выполняется".formatted(chore));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Задача %s успешно завершена".formatted(chore));
    }
}
