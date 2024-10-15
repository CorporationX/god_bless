package Microsoft.Outlook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();

        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        try {
            FileInputStream configFile = new FileInputStream("src/main/resources/Microsoft.Outlook.config");
            config.load(configFile);
            configFile.close();
        } catch (IOException error) {
            System.out.println("Ошибка при чтении файла конфигурации: " + error.getMessage());
            return;
        }

        int totalMails = Integer.parseInt(config.getProperty("totalMails"));
        int threadsCount = Integer.parseInt(config.getProperty("threadsCount"));
        int mailsPerThread = totalMails / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * mailsPerThread + 1;
            int endIndex = (i + 1) * mailsPerThread;
            System.out.println("Начальный индекс: " + startIndex);
            System.out.println("Конечный индекс: " + endIndex);

            try {
                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                threads[i] = new Thread(senderRunnable, "номер " + (i + 1));
                threads[i].start();

            } catch (IllegalArgumentException error) {
                System.err.println("Ошибка при создании нового потока: " + error.getMessage());
            }
        }

        for (int i = 0; i < threadsCount; i++) {
            if (threads[i] != null) {
                try {
                    threads[i].join();
                    System.out.println("Поток " + threads[i].getName() + " завершил работу");
                } catch (InterruptedException error) {
                    System.err.println("Поток " + threads[i].getName() + " был прерван.");
                    Thread.currentThread().interrupt();
                }
            }
        }

        System.out.println("Все письма успешно обработаны.");
    }
}
