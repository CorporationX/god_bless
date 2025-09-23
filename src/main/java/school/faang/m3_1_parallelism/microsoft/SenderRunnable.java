package school.faang.m3_1_parallelism.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final String[] messages;
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            for (int i = startIndex; i <= endIndex; i++) {
                Thread.sleep(2);
            }
            System.out.println(threadName + " закончил обработку писем с " +
                    messages[startIndex] + " по " + messages[endIndex]);
        } catch (InterruptedException e) {
            System.out.println("Возникло исключение в процессе работы потока: " + threadName);
        }
    }
}
