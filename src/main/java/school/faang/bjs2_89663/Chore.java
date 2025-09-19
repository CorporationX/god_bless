package school.faang.bjs2_89663;

public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}