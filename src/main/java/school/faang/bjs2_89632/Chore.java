package school.faang.bjs2_89632;

public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        try {
            System.out.printf(Thread.currentThread().getName() + " Выполняет задачу: %s\n", chore);
            Thread.sleep(200);
            System.out.printf(Thread.currentThread().getName() + ": Задача %s выполнена\n", chore);
        } catch (InterruptedException e) {
            System.out.printf(
                    "Поток %s: Меня прервали в процессе выполнения задачи\n", Thread.currentThread().getName()
            );
            Thread.currentThread().interrupt();
        }
    }
}