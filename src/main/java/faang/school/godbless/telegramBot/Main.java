package faang.school.godbless.telegramBot;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        Thread firstThread = new Thread(() -> telegramBot.sendMessage("Hi!"));
        Thread secondThread = new Thread(() -> telegramBot.sendMessage("Hello"));
        Thread thirdThread = new Thread(() -> telegramBot.sendMessage("Hola"));
        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
