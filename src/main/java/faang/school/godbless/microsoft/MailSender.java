package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalEmail = 1000;
        int amountThread = 5;
        int count = 0;


        int startIndex = 1;
        int endIndex = totalEmail / amountThread;
        for (int i = 0; i < amountThread - 1; i++) {
            Thread thread = new Thread(new SenderRunnable(new StackMail(startIndex, endIndex)));
            startIndex = endIndex + 1;
            endIndex = totalEmail / amountThread + endIndex;
            thread.start();
        }
        Thread thread = new Thread(new SenderRunnable(new StackMail(startIndex, totalEmail)));
        thread.start();
        thread.join();
        System.out.println("All emails were sent!");
    }
}
