package school.faang.bjs2_81197;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " закончил " + chore);
        } catch (InterruptedException e) {
            System.out.println(chore + " была прервана ");
            Thread.currentThread().interrupt();
            throw  new RuntimeException(e);
        }
    }
}
