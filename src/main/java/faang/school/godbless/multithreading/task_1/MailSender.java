package faang.school.godbless.multithreading.task_1;

import faang.school.godbless.multithreading.task_1.sender.SenderRunnable;

public class MailSender {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new SenderRunnable(1, 100));
        Thread secondThread = new Thread(new SenderRunnable(101, 200));
        Thread thirdThread = new Thread(new SenderRunnable(201, 300));
        Thread fourthThread = new Thread(new SenderRunnable(301, 400));
        Thread fifthThread = new Thread(new SenderRunnable(401, 500));

        try {
            firstThread.start();
            firstThread.join();
            secondThread.start();
            secondThread.join();
            thirdThread.start();
            thirdThread.join();
            fourthThread.start();
            fourthThread.join();
            fifthThread.start();
            fifthThread.join();
            System.out.println(Thread.currentThread().getName() + " сообщает о том, что все письма отправлены");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
