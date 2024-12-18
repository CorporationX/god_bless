package school.faang.sprint_3.task_48204;

public class MailSender {

    public static void main(String[] args) {
        int emailsCount = 1000;
        int threadsCount = 5;
        int packageSize = emailsCount / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int nextI = i + 1;
            var sender = new SenderRunnable(i * packageSize, nextI * packageSize + (nextI == threadsCount ? 1 : 0));
            threads[i] = new Thread(sender);
            threads[i].start();
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены!");
    }
}
