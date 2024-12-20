package school.faang.sprint3.bjs2_48519.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Запущен поток %s. Отправлено письмо: %s\n", Thread.currentThread().getName(), i);
        }
    }
}
