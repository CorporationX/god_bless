package school.faang.godbless.bjs2_37771;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadsNumber = 5;
        int mailNumber = 1000;
        MailSender.sendMail(threadsNumber, mailNumber);
    }
}
