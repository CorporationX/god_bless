package faang.school.godbless.microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = i * startIndex + 100 ;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads){
            thread.join();
        }
    }
}
