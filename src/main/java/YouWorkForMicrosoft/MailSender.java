package YouWorkForMicrosoft;

public class MailSender {
    public static void main(String[] args) {
        int emailsNumber = 1000;
        int batchSize = 200;
        int startIndex = 1;
        int endIndex;

        SenderRunnable senderRunnable = new SenderRunnable();
        while (emailsNumber > 0) {
            if (emailsNumber < batchSize) {
                batchSize = emailsNumber;
            }
            emailsNumber -= batchSize;
            endIndex = startIndex + batchSize - 1;

            System.out.println("Отправляются письма " + startIndex + " - " + endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();

            startIndex += batchSize;
        }
    }
}
