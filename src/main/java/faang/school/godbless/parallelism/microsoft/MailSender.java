package faang.school.godbless.parallelism.microsoft;

public class MailSender {

    public static void main(String[] args) {
        int numberOfThreads = 5;
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < 5; i++) {
            int startIndex = (i * 200) + 1;
            int endIndex = ((i + 1) * 200);
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван: " + e.getMessage());
            }
        }
        System.out.println("Все сообщения отправлены.");
    }

}
