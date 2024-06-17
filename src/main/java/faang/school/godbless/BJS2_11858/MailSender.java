package faang.school.godbless.BJS2_11858;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        var firstThread = new Thread(new SenderRunnable(0, 200));
        var secondThread = new Thread(new SenderRunnable(201, 400));
        var thirdThread = new Thread(new SenderRunnable(401, 600));
        var fourthThread = new Thread(new SenderRunnable(601, 800));
        var fifthThread = new Thread(new SenderRunnable(801, 1000));
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();
        try {
            firstThread.join();
            secondThread.join();
            thirdThread.join();
            fourthThread.join();
            fifthThread.join();
        } catch (InterruptedException exception) {
            log.info(exception.getMessage());
        }
        System.out.println("All thread were launched");
    }
}
