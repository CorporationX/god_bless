package faang.school.godbless.telegram_bot;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int mesNumber = i;
            threads[i] = new Thread(() -> telegramBot.sendMessage("Сообщение " + mesNumber));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все сообщения отправлены");
    }
}
