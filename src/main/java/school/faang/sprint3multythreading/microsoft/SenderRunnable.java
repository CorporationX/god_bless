package school.faang.sprint3multythreading.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо №%s отправлено. Поток-%S\n", i, Thread.currentThread().getName());
        }
    }
}