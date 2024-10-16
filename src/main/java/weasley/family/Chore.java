package weasley.family;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " запустился и выполняет задачу " + chore);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException error) {
            System.err.println(threadName + " прервался.");
            Thread.currentThread().interrupt();
        }

        System.out.println(threadName + " обработал задачу " + chore);
    }
}
