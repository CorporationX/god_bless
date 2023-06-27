package Sprint_4_Task1;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = null;
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            thread = new Thread(new SenderRunnable(startIndex,endIndex));
            thread.start();

        }
        thread.join(100000);
        System.out.println(" Поле");
    }
}
