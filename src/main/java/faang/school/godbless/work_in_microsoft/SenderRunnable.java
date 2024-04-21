package faang.school.godbless.work_in_microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Отправка сообщения " + i + " из потока " + Thread.currentThread().getName());
        }
    }
}
