package telegram_bot;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(3);

        for (int i = 1; i <= 6; i++) {
            int threadId = i;
            new Thread(() -> {
                bot.sendMessage("Message from Thread " + threadId);
                System.out.println("Thread " + threadId + " done");
            }).start();
        }
    }
}
