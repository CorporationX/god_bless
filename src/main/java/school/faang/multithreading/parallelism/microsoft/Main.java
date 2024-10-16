package school.faang.multithreading.parallelism.microsoft;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        mailSender.send(1000, 200);
    }
}
