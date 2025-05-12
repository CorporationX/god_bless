package school.faang.reverse.microsoft;

public class Main {
    public static void main(String[] args) {
        final Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200;
            int endIndex = startIndex + 200;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все письма успешно отправлены.");
    }
}