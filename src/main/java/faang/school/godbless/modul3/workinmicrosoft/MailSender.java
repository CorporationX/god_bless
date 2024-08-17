package faang.school.godbless.modul3.workinmicrosoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MailSender {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.range(0, 5).map(i -> i * 200 + 1).forEach(startIndex -> {
            int endIndex = startIndex + 199;
            executor.submit(new SenderRunnable(startIndex, endIndex));
        });

        executor.shutdown();

        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All emails have been sent successfully");
            } else {
                System.out.println("Some emails were not sent in the allotted time");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
