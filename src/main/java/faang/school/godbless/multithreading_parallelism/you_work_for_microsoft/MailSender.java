package faang.school.godbless.multithreading_parallelism.you_work_for_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            threadList.add(new Thread(new SenderRunnable(i * 200 + 1, (i + 1) * 200)));
            threadList.get(i).start();
        }

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        System.out.println("Готово!");


    }
}
