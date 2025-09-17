package school.faang.bjs2_91310;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет: " + chore);

        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил: " + chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
