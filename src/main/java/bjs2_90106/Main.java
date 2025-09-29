package bjs2_90106;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        Thread[] threads = new Thread[15];

        for (int i = 0; i < threads.length; i++) {
            int finalI = i + 1;
            threads[i] = new Thread(() ->
                    bot.sendMessage("Привет #" + finalI),
                    "Поток-" + finalI
            );
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Задача выполнена!");
    }
}