package school.faang.cashedpoolthread;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println("We are in the thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был попытан прервать в течение периода выполнения.");
        }
    }
}
