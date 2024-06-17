package faang.school.godbless.BJS211915;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All emails have been sent successfully!");
    }
}
