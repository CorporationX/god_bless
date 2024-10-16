package school.faang.godbless.bjs2_37771;

public class Main {
    public static void main(String[] args) {
        // test 1
        int threadsNumber = 5;
        int mailNumber = 10;
        MailSender.sendMail(threadsNumber, mailNumber);

        // test 2
        threadsNumber = 5;
        mailNumber = 1000;
        MailSender.sendMail(threadsNumber, mailNumber);
    }
}
