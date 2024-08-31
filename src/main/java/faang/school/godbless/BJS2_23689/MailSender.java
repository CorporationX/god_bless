package faang.school.godbless.BJS2_23689;

public class MailSender {
    public static void main(String[] args) {

        Thread[] arrayThread = new Thread[5];

        for (int i = 0; i < arrayThread.length; i++) {
            int startIndex = i * 200;
            int endIndex = startIndex + 200;

            SenderRunnable runnable = new SenderRunnable(startIndex, endIndex);
            arrayThread[i] = new Thread(runnable);
            arrayThread[i].start();
        }

        try {
            for (Thread element : arrayThread) {
                element.join();
            }
            System.out.println("Все сообщения отправлены");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
