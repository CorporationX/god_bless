package faang.school.godbless.multithreading.microsoft;

public class MailSender {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i+=2) {
            new Thread(new SenderRunnable(i*100+1, (i+2)*100)).start();
        }
    }
}
