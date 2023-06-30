package faang.school.godbless.telegramBot;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(() -> {
                String message = "Thread " + threadNumber + " message";
                bot.sendMessage(message);
                System.out.println("Thread " + threadNumber + " sent message");
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task completed");
    }
}
