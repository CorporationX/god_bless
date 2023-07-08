package faang.school.godbless.parallel.work_in_microsoft;

import java.util.Arrays;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        String[] letters = new String[1000];
        Arrays.fill(letters, "some letter");
        SenderRunnable sender1 = new SenderRunnable(letters, 0, 199);
        SenderRunnable sender2 = new SenderRunnable(letters, 200, 399);
        SenderRunnable sender3 = new SenderRunnable(letters, 400, 519);
        SenderRunnable sender4 = new SenderRunnable(letters, 600, 749);
        SenderRunnable sender5 = new SenderRunnable(letters, 800, 999);

        Thread thread1 = new Thread(sender1);
        Thread thread2 = new Thread(sender2);
        Thread thread3 = new Thread(sender3);
        Thread thread4 = new Thread(sender4);
        Thread thread5 = new Thread(sender5);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println("Отправка писем завершена");
    }
}


