package BJS2_23677_WorkingInMicrosoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = 200 * (i + 1);

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            System.out.println("Thread " + (i + 1) + " is on the way...");
            thread.join();
            System.out.println(thread.getName() + " Sent all!");
        }

        System.out.println("All messages have been sent!");

    }


}
