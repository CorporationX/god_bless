package faang.school.godbless;

public class MailSender {
    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            thread = new Thread(sender);
            thread.start();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все потоки закончили работу, программа завершена");
    }
}
