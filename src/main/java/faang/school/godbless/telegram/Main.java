package faang.school.godbless.telegram;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot1 = new TelegramBot();
        TelegramBot telegramBot2 = new TelegramBot();

        Thread thread1 = new Thread(() -> telegramBot1.sendMessage("Привет как дела"));
        Thread thread2 = new Thread(() -> telegramBot2.sendMessage("Назови сталицы всех стран мира"));

        thread1.start();
        thread2.start();
    }
}
