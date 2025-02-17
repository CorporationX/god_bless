package school.faang.workinmicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final Integer startIndex;
    private final Integer endIndex;

    /**
     * Метод отправки сообщений.
     * Так же метод имеет симуляцию задержки отправки сообщений
     */
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                System.out.printf("letter %s is send \n", i);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.print("Thread interrupted");
            }
        }
    }
}
