package job.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 5;
        int mailQueue = 1000;
        int mailPerThread = mailQueue / threadCount;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * mailPerThread;
            int endIndex = startIndex + mailPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            try {
                threads[i].start();
                threads[i].join();
            } catch (Exception e) {
                System.out.println("Ошибка запуска потока " + e.getMessage());
            }
        }
    }
}
