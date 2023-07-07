package faang.school.godbless.telegramBot;

public class Main {
    public static void main(String[] args) {

        TelegramBot bot = new TelegramBot();

        for (int i = 0; i < 100; i++) {
            String message = "Message " + i;
            new Thread(() -> {
                try {
                    bot.sendMessage(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

}
