package school.faang.multithreading.parallelism.microsoft;

public class Main {
    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        mailSender.send(1000, 200);
    }
}
