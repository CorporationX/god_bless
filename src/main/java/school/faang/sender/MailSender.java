package school.faang.sender;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int allMessage = 1000;
        int threadNumber = 5;
        int size = allMessage / threadNumber;
        Thread[] threads = new Thread[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(new SenderRunnable(i * size, (i + 1) * size));
            threads[i].start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
