package faang.school.godbless.WorkMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class SenderRunnable {
    public static void main(String[] args) throws InterruptedException {
        int letters = 100;
        int countThread = 5;
        int start = 1;
        int end = 0;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            end++;
            if (end % (letters / countThread) == 0){
                Thread thread = new Thread(new MailSender(start, end));
                thread.start();
                threads.add(thread);
                start = end + 1;
            }
        }
        for (Thread thread:threads) {
            thread.join();
        }
        System.out.println("End!");
    }

}
