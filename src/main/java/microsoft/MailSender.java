package microsoft;

import lombok.Data;
import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MailSender {

    public static void main(String[] args) {
        int startIndex = 0;
        int endindex = 200;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endindex);
            executorService.submit(senderRunnable);
            startIndex += 200;
            endindex += 200;
        }
        executorService.shutdown();
    }

}
