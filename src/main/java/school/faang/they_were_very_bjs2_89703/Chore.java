package school.faang.they_were_very_bjs2_89703;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
