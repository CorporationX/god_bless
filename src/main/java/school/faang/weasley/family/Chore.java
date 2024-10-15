package school.faang.weasley.family;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Записываем сообщение в логи" + e.getMessage());
        }
    }
}
