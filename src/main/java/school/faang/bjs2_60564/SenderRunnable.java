package school.faang.bjs2_60564;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("[Поток %S] Обработано письмо с индексом: %d%n", Thread.currentThread().getName(), i);
        }
    }
}
