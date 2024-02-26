package faang.school.godbless.BJS2_3136;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        var messageList = Message.getList(1000);
        for (int i = 0; i < 1000; i += 200){
            Thread newThread = new Thread(new SenderRunnable(i, i+200, messageList));
            newThread.start();
            newThread.join();
        }
        System.out.println("Main thread finished");
    }
}
