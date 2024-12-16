package school.faang.sprint_3.task_43554;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int messagesNumber = 1000;
        int threadsNumber = 5;
        int batchNumber = messagesNumber / threadsNumber;
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threadsNumber; i++) {
            int start = i * batchNumber;
            int end = (i + 1) * batchNumber;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
