package school.faang.microsoft;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadsCount = 5;

        MailSender mailSender = new MailSender(totalMessages, threadsCount);
        mailSender.sendAllMails();
    }
}