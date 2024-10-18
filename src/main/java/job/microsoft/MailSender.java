package job.microsoft;

public class MailSender {
    public static void main(String[] args) {

        int threadCount = 5;
        int mailQueue = 1000;
        int mailPerThread = mailQueue / threadCount;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * mailPerThread;
            try {
                int endIndex = startIndex + mailPerThread;
                threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
                threads[i].start();
                threads[i].join();
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (OutOfMemoryError e) {
                System.out.println("Недостаточно памяти для создания нового потока " + e.getMessage());
            }
        }
    }
}
