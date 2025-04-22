package school.faang.stream3.parallelismthread.workformicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {

        int emailCount = 1000;
        int bucketSize = 200;
        List<List<Email>> emailBuckets = new ArrayList<>();

        int currentBucket = -1;
        for (int i = 0; i < emailCount; i++) {
            if (i % bucketSize == 0) {
                emailBuckets.add(new ArrayList<>());
                currentBucket += 1;
            }
            Email email = new Email();
            emailBuckets.get(currentBucket).add(email);
        }

        int numberOfThreads = emailBuckets.size();
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new SenderRunnable(emailBuckets.get(i)));
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
