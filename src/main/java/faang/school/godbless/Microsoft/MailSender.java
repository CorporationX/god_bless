package faang.school.godbless.Microsoft;

public class MailSender {
    public static void main(String[] args) {
        int mailThreads = 200;
        int numThreads = 5;
        for (int i = 0; i < numThreads; i++){
            int startIndex = i * mailThreads + 1;
            int endIndex = startIndex + mailThreads;
            new Thread(new SenderRunnable(startIndex, endIndex)).start();
        }
    }
}




