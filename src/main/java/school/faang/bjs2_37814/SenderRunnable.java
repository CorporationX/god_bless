package school.faang.bjs2_37814;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            sendEmail(i);
        }
    }
    private void sendEmail(int emailIndex){
        System.out.println("Email" + emailIndex + "Send");
    }
}
