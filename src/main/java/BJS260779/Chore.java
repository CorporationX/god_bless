package BJS260779;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        log.info("Поток : " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
            log.info("Задача : " + chore + " Выполнена");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
