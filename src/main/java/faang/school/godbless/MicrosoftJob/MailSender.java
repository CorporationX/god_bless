package faang.school.godbless.MicrosoftJob;

public class MailSender {
    public static void main(String[] args) {
        Config config = new Config();
        int totalEmails = config.get("totalEmails");
        int threadsCount = config.get("threadsCount");
        int emailsPerThread = totalEmails / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = (i + 1) * emailsPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex), "Thread-" + (i + 1));
            threads[i].start();
        }

       System.out.println("All emails have been sent successfully.");
    }
};
