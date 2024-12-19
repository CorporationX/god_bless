package school.faang.task_48735;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        var threadsCount = 5;
        var tasksCount = 1000;
        var taskPerThreadCount = tasksCount / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            var start = i * taskPerThreadCount;
            var end = (i + 1) * taskPerThreadCount;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Программа завершилась!");
    }
}
