package faang.school.godbless.microsoft;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SenderRunneble(1, 21));
        thread.start();
        Thread thread1 = new Thread(new SenderRunneble(21, 41));
        thread1.start();
        Thread thread2 = new Thread(new SenderRunneble(41, 61));
        thread2.start();
        Thread thread3 = new Thread(new SenderRunneble(61, 81));
        thread3.start();
        Thread thread4 = new Thread(new SenderRunneble(81, 101));
        thread4.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println("Все сообщения доставлены");
    }
}