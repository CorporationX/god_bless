package school.faang.sprint2.task47010.service;

public class EmailService implements Sender {
    public void sendMessage(String message) {
        System.out.println(">>Message was sent by Email service");
        System.out.println("Email: " + message);
        System.out.println("----");
    }
}
