package school.faang.microsoft;

import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static final String stream0 = "Genesis";
    public static final String stream1 = "First";
    public static final String stream2 = "Second";
    public static final String stream3 = "Third";
    public static final String stream4 = "Fourth";

    public static void main(String[] args) {
        List<String> stream = Arrays.asList(stream0, stream1, stream2, stream3, stream4);
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex, stream.get(i)));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("shutdown /r");
    }


}