package school.faang.microsoft;

public class MicrosoftMain {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerThread = totalEmails / 5;

        MailSender mailSender = new MailSender();
        mailSender.sendMails(totalEmails, emailsPerThread);
    }
}
