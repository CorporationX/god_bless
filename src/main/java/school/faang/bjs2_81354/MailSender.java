package school.faang.bjs2_81354;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        SenderRunnable firstBatch = new SenderRunnable(0, 199);
        SenderRunnable secondBatch = new SenderRunnable(200, 399);
        SenderRunnable thirdBatch = new SenderRunnable(400, 599);
        SenderRunnable fourthBatch = new SenderRunnable(600, 799);
        SenderRunnable fifthBatch = new SenderRunnable(800, 999);

        try {
            Thread firstBatchThread = new Thread(firstBatch, "sending 0-199 letters");
            firstBatchThread.start();
            System.out.println("Awaiting 0-199 letters...");
            firstBatchThread.join();

            Thread secondBatchThread = new Thread(secondBatch, "sending 200-399 letters");
            secondBatchThread.start();
            System.out.println("Awaiting 0-199 letters...");
            firstBatchThread.join();

            Thread thirdBatchThread = new Thread(thirdBatch, "sending 400-599 letters");
            thirdBatchThread.start();
            System.out.println("Awaiting 400-599 letters...");
            thirdBatchThread.join();

            Thread fourthBatchThread = new Thread(fourthBatch, "sending 600-799 letters");
            fourthBatchThread.start();
            System.out.println("Awaiting 600-799 letters...");
            fourthBatchThread.join();

            Thread fifthBatchThread = new Thread(fifthBatch, "sending 800-999 letters");
            fifthBatchThread.start();
            System.out.println("Awaiting 800-999 letters...");
            fifthBatchThread.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("No mail received...");
        }


    }
}
