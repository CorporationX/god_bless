package work_for_Microsoft;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static List<Thread> threadList = new ArrayList<>();

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = 200 * (i + 1);
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            threadList.add(thread);
            thread.start();
        }
        for (var tread : threadList) {
            tread.join();
            System.out.println("task completed");
        }
    }
}