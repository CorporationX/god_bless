package school.faang.task_48196;

public class MailSender {
    public static void main(String[] args) {
        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new SenderRunnable(i * 200, i * 200 + 199));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все писма отправленны");
    }
}
