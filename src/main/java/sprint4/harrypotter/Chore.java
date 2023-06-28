package sprint4.harrypotter;

public record Chore(String chore) implements Runnable {

    @Override
    public synchronized void run() {
        System.out.printf("В потоке %s мы выполняем работу по дому: %s\n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        System.out.printf("Работа в потоке %s - \"%s\" выполнена!\n", Thread.currentThread().getName(), chore);
    }
}
