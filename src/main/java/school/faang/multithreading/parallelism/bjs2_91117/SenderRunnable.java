package school.faang.multithreading.parallelism.bjs2_91117;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо № %d отправлено%n", i);
        }
    }
}