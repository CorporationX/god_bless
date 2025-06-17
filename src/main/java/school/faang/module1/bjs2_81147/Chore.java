package school.faang.module1.bjs2_81147;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable{

    private final String chore;
    private final static int TIMEOUT = 3000;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {

        log.info("Поток {} начинает задачу {}", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток {} был прерван", Thread.currentThread().getName());
        }
        log.info("Поток {} завершил задачу {}", Thread.currentThread().getName(), chore);
    }
}