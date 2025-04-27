package school.faang.they_were_very_nice_but_extremely_poor;

public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        System.out.println("Выполняю задачу: " + chore + " в потоке: " + Thread.currentThread().getName());
        try {
            int duration = (int) (Math.random() * 4000) + 1000;
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Задача " + chore + " была прервана.");
            return;
        }
        System.out.println("Задача " + chore + " выполнена в потоке: " + Thread.currentThread().getName());
    }
}