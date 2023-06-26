package faang.school.godbless.YouAreWorkingInMicrosoft;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {

    private int startIndex = 1;
    private int endIndex = 201;

    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(new SenderRunnable(mailSender.startIndex,mailSender.endIndex));
            mailSender.startIndex += 200;
            mailSender.endIndex += 200;
        }
        executor.shutdown();
    }
}

