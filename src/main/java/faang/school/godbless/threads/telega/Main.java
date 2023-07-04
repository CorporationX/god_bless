package faang.school.godbless.threads.telega;

public class Main {

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> telegramBot.sendMessage());
            thread.start();
        }

    }
}
