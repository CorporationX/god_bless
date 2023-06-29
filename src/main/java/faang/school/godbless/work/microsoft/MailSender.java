package faang.school.godbless.work.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> lettersList = new ArrayList<>(1000);

        for (int i = 0; i < 1000; i++) {
            lettersList.add(i);
        }

        List<SenderRunnable> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new SenderRunnable(i * 200, ++i * 200, lettersList));
        }

        List<Thread> threads = list.stream().map(s -> new Thread(s)).toList();
        threads.stream().forEach(t -> t.start());

        threads.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All letters have sand");

    }
}
