package school.faang.workMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int engIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < engIndex; i++) {
            System.out.println("Отправлено через поток " + Thread.currentThread().getName() + " " + i);
        }
    }
}