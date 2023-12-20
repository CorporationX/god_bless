package faang.school.godbless.work_in_microsoft;


public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;
    private static int mailID;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            mailID++;
            System.out.println("Сообщение №" + mailID + " отправлено!");
        }
    }
}
