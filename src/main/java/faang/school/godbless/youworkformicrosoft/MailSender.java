package faang.school.godbless.youworkformicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final List<Thread> threadListOfLatters = new ArrayList<>();

    public static void main(String... args) {
        for (int i = 1, j = 0; i < 1000; i = i + 200, j++) {
            threadListOfLatters.add(new Thread(new SenderRunnable(i, i + 199)));
            threadListOfLatters.get(j).start();
        }

        for (int j = 0; j < threadListOfLatters.size(); j++)
            try {
                threadListOfLatters.get(j).join();
                System.out.println((j + 1) + " Поток завершен");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
