package school.faang.bjs248696;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        int mails = 1000;
        int mailGroups = 5;
        int mailsInOneGroup = mails / mailGroups;

        Thread[] threads = new Thread[mailGroups];
        for (int i = 0; i < mailGroups; i++) {
            int start = i * mailsInOneGroup;
            int end = (i + 1) * mailsInOneGroup;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
