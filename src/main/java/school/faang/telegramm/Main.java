package school.faang.telegramm;

public class Main {
    private static final int MILLIS = 100;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                bot.sendMessage("Привет от потока!");
                try {
                    Thread.sleep(MILLIS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(task, "Поток 1");
        Thread t2 = new Thread(task, "Поток 2");
        Thread t3 = new Thread(task, "Поток 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Задача выполнена!");
    }
}
