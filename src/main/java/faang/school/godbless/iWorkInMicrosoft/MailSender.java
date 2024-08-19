package faang.school.godbless.iWorkInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i += 200) {
            list.add(new Thread(new SenderRunnable(i, i + 199)));
            list.get(list.size() - 1).start();
        }

        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Well done!!!");
    }
}
