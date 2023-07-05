package faang.school.godbless.sprint3.telegram;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        Thread thread = new Thread(() -> bot.sendMessage("Hello"));
        Thread thread1 = new Thread(() -> bot.sendMessage("Hello"));
        Thread thread2 = new Thread(() -> bot.sendMessage("Hello"));
        Thread thread3 = new Thread(() -> bot.sendMessage("Hello"));
        Thread thread4 = new Thread(() -> bot.sendMessage("Hello"));
        Thread thread5 = new Thread(() -> bot.sendMessage("Hello"));
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
