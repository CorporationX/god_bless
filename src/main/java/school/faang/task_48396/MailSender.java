package school.faang.task_48396;

public class MailSender {

    public static void main(String[] args) {
        final int emailsThread = 200;
        final int numbersOfThread = 5;
        Thread[] theards = new Thread[numbersOfThread];

        for (int i = 0; i < numbersOfThread; i++) {
            int startIndex = i * emailsThread + 1;
            int endIndex = startIndex + emailsThread - 1;

            theards[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            theards[i].start();
        }

        for (Thread thread : theards) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Поток прерван " + thread.getName());
            }
        }
        System.out.println("Все письма отправлены!!");
    }
}