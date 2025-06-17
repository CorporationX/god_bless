package school.faang.parallelmessage;


public class MailSender {
    public static void main(String[] args) {
        int batch = 1000 / 5;
        Thread[] thread = new Thread[5];

        for (int i = 0; i < 5; i++) {
            thread[i] = new Thread(new SenderRunnable(i * batch, (i + 1) * batch));
            thread[i].start();
        }

    }
}
