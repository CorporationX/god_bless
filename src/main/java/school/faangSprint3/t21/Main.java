package school.faangSprint3.t21;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        int numberOfThreads = 10;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            final int messageIndex = i;
            threads[i] = new Thread(() -> {
                bot.sendMessage("Сообщение " + messageIndex);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Ошибка при ожидании завершения потока: " + e.getMessage());
            }
        }

        System.out.println("Все сообщения отправлены. Задача выполнена.");
    }
}
