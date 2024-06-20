package faang.school.godbless.module1.sprint3.task1;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int startIndex = 1;
        int endIndex = 201;

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            startIndex += 200;
            endIndex += 200;
            thread.join();
            System.out.println(thread.isAlive());
        }

    }
}

