package faang.school.godbless.multithreading.telegram_bot;

public class Telegram {
    public static void main(String[] args) throws InterruptedException {
        TelegramBot telegramBot = new TelegramBot();
        telegramBot.start();

        for (int i = 0; i < 100; i++) {
            Thread.sleep(50);
            telegramBot.sendMessage();
        }
        telegramBot.stop();
    }
}
