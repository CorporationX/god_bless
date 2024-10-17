package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        int currThread = 0;
        int totalMail = 1000;
        int threadMaxMail = 200;

        for (int i = 0; i < totalMail; i++) {

            if(i%threadMaxMail == 0){
                int endIndex = i-199;

                SenderRunnable senderRunnable = new SenderRunnable(i, endIndex);
                Thread thread = new Thread(senderRunnable);
                threads.add(thread);
                threads.get(currThread).start();
                currThread++;
            }

        }
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }

        System.out.println("finished");
    }

}
