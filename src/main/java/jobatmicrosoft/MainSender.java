package jobatmicrosoft;

public class MainSender {

    private static int startIndex = 0;
    private static int endIndex = 0;


    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            startIndex = endIndex + 1;
            endIndex += 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
        }
    }
}
