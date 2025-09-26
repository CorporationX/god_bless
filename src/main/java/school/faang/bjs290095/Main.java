package school.faang.bjs290095;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        for (int i = 0; i < 15; i++) {
            bot.sendMessage("Some message " + i);
            try {
                Thread.sleep(100); // Задержка для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Task completed!");
    }
}
