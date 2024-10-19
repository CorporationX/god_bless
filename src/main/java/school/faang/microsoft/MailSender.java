package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        SenderRunnable mailChunk1 = new SenderRunnable(1, 200);
        SenderRunnable mailChunk2 = new SenderRunnable(201, 400);
        SenderRunnable mailChunk3 = new SenderRunnable(401, 600);
        SenderRunnable mailChunk4 = new SenderRunnable(601, 800);
        SenderRunnable mailChunk5 = new SenderRunnable(801, 1000);

        Thread thread1 = new Thread(mailChunk1);
        Thread thread2 = new Thread(mailChunk2);
        Thread thread3 = new Thread(mailChunk3);
        Thread thread4 = new Thread(mailChunk4);
        Thread thread5 = new Thread(mailChunk5);

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
        System.out.println("All mails were sent");
    }
}
