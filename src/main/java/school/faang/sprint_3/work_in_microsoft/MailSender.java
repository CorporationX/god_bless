package school.faang.sprint_3.work_in_microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread thread = new Thread(new SenderRunnable());
    }
}
