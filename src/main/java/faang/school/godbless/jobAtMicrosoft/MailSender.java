package faang.school.godbless.jobAtMicrosoft;

public class MailSender {
public static void main(String[] args) {
    int totalEmails = 1000;
    int emailsPerThread = totalEmails/5;

    Thread[] threads = new Thread[5];

    for(int i = 0; i < 5; i++) {
        int startIndex  = i * emailsPerThread;
        int endIndex = (i + 1) * emailsPerThread;
        SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
        threads[i] = new Thread(senderRunnable);
        threads[i].start();
    }

    for(Thread thread : threads) {
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("All emails have been successfully sent.");
}
}
