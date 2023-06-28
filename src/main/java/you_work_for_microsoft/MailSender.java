package you_work_for_microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        List<SenderRunnable> task = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int start = i*200;
            int end = start+200;
            task.add(new SenderRunnable(start,end));
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(task.get(i));
        }
        executor.shutdown();
    }
}
