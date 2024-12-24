package school.faang.task_48148;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int countMessage = 1000;
        int countThread = 5;
        int batch = countMessage / countThread;

        Thread[] threads = new Thread[countThread];

        for (int i = 0; i < countThread; i++) {
            int startIndex = i * batch;
            int endIndex = (1 + i) * batch;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }

        System.out.println("Все письма доставлены!");

    }
}
