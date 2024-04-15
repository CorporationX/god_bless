package faang.school.godbless.outlook;

public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.println("Email from " + startIndex + " to " + endIndex + " were sent successfully");
    }
}



