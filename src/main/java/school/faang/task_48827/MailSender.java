package school.faang.task_48827;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable sendRun = new SenderRunnable(0, 1000);
        Thread threadSendRun = new Thread(sendRun);
        threadSendRun.start();
    }
}
