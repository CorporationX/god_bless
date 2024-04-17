package faang.school.godbless.you_work_for_microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = i * 200 + 200;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            thread.join();
        }
        System.out.println("Все письма успешно отправлены.");
    }
}
