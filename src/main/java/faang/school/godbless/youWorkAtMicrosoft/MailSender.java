package faang.school.godbless.youWorkAtMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        final int QUANTITY = 1000;
        final int THREADQUANITY = 5;

        for (int i = 0; i < THREADQUANITY; i++) {
            int startIndex = (QUANTITY / THREADQUANITY) * i + 1;
            int endIndex = (QUANTITY / THREADQUANITY) * (i + 1);

            Thread thread = new Thread(
                    new SenderRunnable(startIndex, endIndex)
            );

            thread.start();

            thread.join();
        }

        System.out.println("--------------------- \nВсе сообщения посланы");
    }
}
