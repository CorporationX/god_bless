package faang.school.godbless.ThirdSprint.BJS2_23797;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = 200 + startIndex - 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threadList.add(thread);
            thread.start();
        }

        threadList.stream()
                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("Все письма отправлены!");
    }
}
