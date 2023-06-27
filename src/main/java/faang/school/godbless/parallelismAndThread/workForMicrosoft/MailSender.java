package faang.school.godbless.parallelismAndThread.workForMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int numberOfMessages = 1000;
        int countOfThreads = 5;
        int messagesToThread = numberOfMessages / countOfThreads;

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < countOfThreads; i++) {
            int startIndex = i * messagesToThread + 1;
            int endIndex = i * messagesToThread + messagesToThread;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threadList.add(thread);
            thread.start();
        }

        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Обработка писем завершена!");
    }
}
