package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;
            new Thread(() -> {
                String message = "Message from thread " + threadNumber;
                bot.sendMessage(message);
            }).start();
        }

        System.out.println("Task completed.");
    }
}
