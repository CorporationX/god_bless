package school.faang.theywerenice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable{
    private String choreName;

    @Override
    public void run() {
        Thread.currentThread().getName();
        System.out.println("Начинаю " + choreName);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Закончил с " + choreName);
    }
}
