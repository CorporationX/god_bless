package Microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSendler {
    public static void main(String[] args) {
        int totalMessage = 1000;
        int threadsCount = 5;
        int batchSize = totalMessage / threadsCount;
        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads [i] =new Thread(new SanderRunnable(start,end));
            threads[i].start();
        }
        for(Thread thread :threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All letters have been sent");
    }
}
