package school.BJS2_37758;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        int countOfEmails = 1000;
        int countOfThreads = 5;
        int countOfEmailsPerThread = countOfEmails / countOfThreads;

        for (int i = 0; i < countOfThreads; i++) {
            int start = i * countOfEmailsPerThread;
            int end = countOfEmailsPerThread * (i + 1);
            Thread thread = new Thread(new SenderRunnable(start, end));
            thread.start();
            thread.join();
        }
        System.out.println("Все письма отправлены");


    }


}
