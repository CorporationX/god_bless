package faang.school.godbless.alexbulgakoff.multithreading.parallelism.workinmicrosoft;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Data
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for (int i = 0; i < endIndex; i++) {
            System.out.println("Письмо успешно отправлено" + Thread.currentThread());
        }

    }
}
