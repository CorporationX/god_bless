package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; ++i) {
            threads[i] = new Thread(new SenderRunnable(i*200, (i + 1)*200));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все сообщения отправлены");
    }
}
