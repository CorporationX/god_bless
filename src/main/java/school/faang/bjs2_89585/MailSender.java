package school.faang.bjs2_89585;

public class MailSender {
    @SuppressWarnings({"checkstyle:AbbreviationAsWordInName", "checkstyle:MemberName"})
    final int THREAD_COUNT = 5;
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    final int TOTAL_MESSAGES = 1000;
    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        








        Thread thread1 = new Thread(new SenderRunnable(1, 200));
        thread1.start();
        Thread thread2 = new Thread(new SenderRunnable(201, 400));
        thread2.start();
        Thread thread3 = new Thread(new SenderRunnable(401, 600));
        thread3.start();
        Thread thread4 = new Thread(new SenderRunnable(601, 800));
        thread4.start();
        Thread thread5 = new Thread(new SenderRunnable(801, 1000));
        thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            System.out.println("Все письма разосланы.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток main не смог дождаться, его прервали.");
        }
    }
}
