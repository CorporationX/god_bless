package school.faang_sprint_3.you_working_in_microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        var lettersAmount = 1000;
        var threadsAmount = 5;
        var partition = lettersAmount / threadsAmount;

        Thread[] threads = new Thread[threadsAmount];
        for (int i = 0; i < threads.length; i++) {
            int begin = i * partition;
            int end = (i + 1) * partition;
            threads[i] = new Thread(new SenderRunnable(begin, end));
            threads[i].start();
        }

        for (var thread : threads) {
            thread.join();
        }
        System.out.println("Successfully completed");
    }
}
